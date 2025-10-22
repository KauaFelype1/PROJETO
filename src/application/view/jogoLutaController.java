package application.view;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import application.view.jogoController.Obstaculo;
import application.view.jogoTiroController.Tiro;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class jogoLutaController {
	
	@FXML
    private Canvas canva;

    private double playerX=200;
    private final double playerY=500;
    private final double raio=16;
    private final double larguraTela=360;
    private final double alturaTela=600;
    private int pontuacao=0;
    private ArrayList<Inimigo> inimigos= new ArrayList();
    private ArrayList<Ataque> ataques= new ArrayList();
    private ArrayList<Spcial> spcials= new ArrayList();
    private ArrayList<AtaqueInimigo> ataquesinimigos= new ArrayList();
    private Random random = new Random();
    private boolean esquerda,direita;
    private int vida_player = 3;
    private boolean jogoAtivo = true;
    
    private Image imagemPlayer;
    private Image imagemObstaculo;
    
    
    @FXML
    public void initialize() {
        imagemPlayer = new Image(getClass().getResourceAsStream("nave.png"));
        //imagemObstaculo = new Image(getClass().getResourceAsStream("neon.PNG"));
        imagemObstaculo = new Image(getClass().getResourceAsStream("nav_et2.png"));
    	//TESTES IMAGENS
        /*imagemPlayer = new Image(getClass().getResourceAsStream("Frajola.png"));
        imagemObstaculo = new Image(getClass().getResourceAsStream("Helo.png"));
        */

        canva.setFocusTraversable(true);
        canva.requestFocus();

        GraphicsContext gc = canva.getGraphicsContext2D();

        canva.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) esquerda = true;
            if (e.getCode() == KeyCode.RIGHT) direita = true;
            if (e.getCode() == KeyCode.SPACE) {
                ataques.add(new Ataque(playerX - 2.5, playerY - raio));
            }
            if(e.getCode() == KeyCode.A) {
            	spcials.add(new Spcial(playerX - 2.5, playerY - raio));
            }
        });

        canva.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.LEFT) esquerda = false;
            if (e.getCode() == KeyCode.RIGHT) direita = false;
        });

        AnimationTimer timer = new AnimationTimer() {
            long lastSpawn = 0,lastSpawnTiro=0;
            long lastSpawAtaqueInimigo=0;
           

            @Override
            public void handle(long now) {
            	if(!jogoAtivo) {
            		gc.setFill(Color.RED);
            		gc.setFont(javafx.scene.text.Font.font(36));
            		gc.fillText("GAME OVER", larguraTela/4, 300);
            		stop();
            		return;
            	}
                atualizar();
                desenhar(gc);

                if (now - lastSpawn > 1_000_000_000) {
                   // obstaculos.add(new Obstaculo((larguraTela - 40) / 2, -40)); // obstáculo centralizado
                    inimigos.add(new Inimigo(random.nextInt((int) larguraTela - 40), -40));
                    lastSpawn = now;
                }
                
                if(now - lastSpawAtaqueInimigo > 1_500_000_000) {
                	for(Inimigo inimigo: inimigos) {
                		ataquesinimigos.add(new AtaqueInimigo(inimigo.x + inimigo.largura / 2, inimigo.y + inimigo.altura));
                	}
                	lastSpawAtaqueInimigo = now;
                }
                
               /*
                if (now - lastSpawnTiro > 100_000_000) {
                    // obstaculos.add(new Obstaculo((larguraTela - 40) / 2, -40)); // obstáculo centralizado
                    tiros.add(new Tiro(playerX - 2.5, playerY - raio));
                     lastSpawnTiro = now;
                 }*/
               
               
            }
        };

        timer.start();
    }

    private void atualizar() {
        if (esquerda && playerX - raio > 0) playerX -= 5;
        if (direita && playerX + raio < larguraTela) playerX += 5;

        // Atualiza obstáculos
        Iterator<Inimigo> itObs = inimigos.iterator();
        while (itObs.hasNext()) {
            Inimigo obs = itObs.next();
            obs.y += 4;
            
            if (Math.abs(obs.x - playerX) < raio * 2 && Math.abs(obs.y - playerY) < raio * 2) {
                vida_player--;
                itObs.remove();

                if (vida_player <= 0) {
                    jogoAtivo = false;
                }
            }


            if (obs.y > alturaTela) {
                itObs.remove();
            }
        }

        // Atualiza tiros
        Iterator<Ataque> itTiro = ataques.iterator();
        while (itTiro.hasNext()) {
            Ataque tiro = itTiro.next();
            tiro.y -= 8;

            if (tiro.y < 0) {
                itTiro.remove();
                continue;
            }
         

            // Verifica colisão com obstáculos
            Iterator<Inimigo> itObsColisao = inimigos.iterator();
            while (itObsColisao.hasNext()) {
                Inimigo obs = itObsColisao.next();
                boolean colidiu = tiro.y <= obs.y + obs.altura &&
                                  tiro.y + tiro.altura >= obs.y &&
                                  tiro.x + tiro.largura >= obs.x &&
                                  tiro.x <= obs.x + obs.largura;

                if (colidiu) {
                    pontuacao++;
                    itObsColisao.remove();
                    itTiro.remove();
                    
                    if(pontuacao % 20 ==0) {
                    	vida_player++;
                    }
                    
                    break;
                }
            }
        }
        
     // Atualiza ataques inimigos
        Iterator<AtaqueInimigo> itAtaqueInimigos = ataquesinimigos.iterator();
        while (itAtaqueInimigos.hasNext()) {
            AtaqueInimigo tiro = itAtaqueInimigos.next();
            tiro.y += tiro.velocidade;

            // Remove tiros que saíram da tela
            if (tiro.y > alturaTela) {
                itAtaqueInimigos.remove();
                continue;
            }

            // Verifica colisão com o player
            if (Math.abs(tiro.x - playerX) < raio * 2 && Math.abs(tiro.y - playerY) < raio * 2) {
                vida_player--;
                itAtaqueInimigos.remove();

                if (vida_player <= 0) {
                    jogoAtivo = false;
                }
            }
        }

        
        
     // Atualiza Spcial
        Iterator<Spcial> itSpcial = spcials.iterator();
        while (itSpcial.hasNext()) {
            Spcial spcial = itSpcial.next();
            spcial.y -= 8;

            if (spcial.y < 0) {
                itSpcial.remove();
                continue;
            }
         

            // Verifica colisão com obstáculos
            Iterator<Inimigo> itObsColisao = inimigos.iterator();
            while (itObsColisao.hasNext()) {
                Inimigo obs = itObsColisao.next();
                boolean colidiu = spcial.y <= obs.y + obs.altura &&
                                  spcial.y + spcial.altura >= obs.y &&
                                  spcial.x + spcial.largura >= obs.x &&
                                  spcial.x <= obs.x + obs.largura;

                if (colidiu) {
                    pontuacao++;
                    itObsColisao.remove();
                   // itSpcial.remove();
                    break;
                }
            }
        }
        
    }

    private void desenhar(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, larguraTela, alturaTela);
       
     // Estrelas
        gc.setFill(Color.WHITE);
        for (int i = 0; i < 50; i++) {
            double estrelaX = random.nextDouble() * larguraTela;
            double estrelaY = random.nextDouble() * alturaTela;
            gc.fillOval(estrelaX, estrelaY, 2, 2);
        }

        gc.drawImage(imagemPlayer, playerX - raio, playerY - raio, raio * 4, raio * 4);

        for (Inimigo obs : inimigos) {
            gc.drawImage(imagemObstaculo, obs.x, obs.y, obs.largura, obs.altura);
        }

        //YELLOW : ORIGINAL
        gc.setFill(Color.YELLOW);
        for (Ataque tiro : ataques) {
            gc.fillRect(tiro.x, tiro.y, tiro.largura, tiro.altura);
        }
        
        gc.setFill(Color.RED);
        for(AtaqueInimigo ataqueinimigo: ataquesinimigos) {
        	gc.fillRect(ataqueinimigo.x, ataqueinimigo.y, ataqueinimigo.largura, ataqueinimigo.altura);
        }
        
        gc.setFill(Color.RED);
        for(Spcial spcial: spcials) {
        	gc.fillRect(spcial.x / 2, spcial.y, spcial.largura, spcial.altura);
        }

        gc.setFill(Color.WHITE);
        gc.setFont(javafx.scene.text.Font.font(18));
        gc.fillText("Pontuação: " + pontuacao, 10, 20);
        
        gc.fillText("Vida: " + vida_player, 10, 40);
        
    }

    // Classe de obstáculos
    class Inimigo {
        double x, y;
        //final double largura = 60;
        //final double altura = 50;
       
        final double largura = 70;
        final double altura = 90;

        Inimigo(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Classe de ataques
    class Ataque {
        double x, y;
        // largura = 5
        // altura = 10
        final double largura = 5;
        final double altura = 10;

        Ataque(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class Spcial {
        double x, y;
        final double largura = 210;
        final double altura = 300;

        Spcial(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class AtaqueInimigo {
        double x, y;
        final double largura = 5;
        final double altura = 10;
        final double velocidade = 6;

        AtaqueInimigo(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
