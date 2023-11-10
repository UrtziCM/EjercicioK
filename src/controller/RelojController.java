package controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.LocalTimeStringConverter;

public class RelojController {

    @FXML
    private ImageView horaDec;

    @FXML
    private ImageView horaUn;

    @FXML
    private ImageView minDec;

    @FXML
    private ImageView minUn;

    @FXML
    private ImageView segDec;

    @FXML
    private ImageView segUn;
    
    @FXML
    private AnchorPane mainPane;
    
    private ImageView[] reloj;
    public Timer timer;

    public void initialize() {
    	reloj = new ImageView[] {
    			horaDec,
    			horaUn,
    			minDec,
    			minUn,
    			segDec,
    			segUn
    	};
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int[] horaDecAhora = horaDecomposed();
				for (int i = 0;i < reloj.length;i++) {
					reloj[i].setImage(imagenDigito(horaDecAhora[i]));
				}
			}
		}, 0, 1000);
    }
    
    private static int[] horaDecomposed() {
    	int[] horaDecomp = new int[6];
    	LocalDateTime hora = LocalDateTime.now();
    	if (hora.getHour() > 10) {
    		int tiempoHoras = hora.getHour();
    		horaDecomp[1] = tiempoHoras %10;
    		horaDecomp[0] = (tiempoHoras / 10) % 10;
    	} else {
    		horaDecomp[1] = hora.getHour();
    		horaDecomp[0] = 0;
    	}
    	if (hora.getMinute() > 10) {
    		int tiempoMin = hora.getMinute();
    		horaDecomp[3] = tiempoMin %10;
    		horaDecomp[2] = (tiempoMin / 10) % 10;
    	} else {
    		horaDecomp[3] = hora.getMinute();
    		horaDecomp[2] = 0;
    	}
    	if (hora.getSecond() > 10) {
    		int tiempoSegundos = hora.getSecond();
    		horaDecomp[5] = tiempoSegundos %10;
    		horaDecomp[4] = (tiempoSegundos / 10) % 10;
    	} else {
    		horaDecomp[5] = hora.getSecond();
    		horaDecomp[4] = 0;
    	}
    	return horaDecomp;
    }
    private Image imagenDigito(int num) {
    	switch (num) {
    		case 0:
    			return new Image(this.getClass().getResource("/img/ZERO.png").toString());
    		case 1:
    			return new Image(this.getClass().getResource("/img/ONE.png").toString());
    		case 2:
    			return new Image(this.getClass().getResource("/img/TWO.png").toString());
    		case 3:
    			return new Image(this.getClass().getResource("/img/THREE.png").toString());
    		case 4:
    			return new Image(this.getClass().getResource("/img/FOUR.png").toString());
    		case 5:
    			return new Image(this.getClass().getResource("/img/FIVE.png").toString());
    		case 6:
    			return new Image(this.getClass().getResource("/img/SIX.png").toString());
    		case 7:
    			return new Image(this.getClass().getResource("/img/SEVEN.png").toString());
    		case 8:
    			return new Image(this.getClass().getResource("/img/EIGHT.png").toString());
    		case 9:
    			return new Image(this.getClass().getResource("/img/NINE.png").toString());
    	}
    	return null;
    }
}