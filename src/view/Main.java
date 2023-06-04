package view;



import java.awt.Point;
import java.io.IOException;












import com.sun.javafx.scene.traversal.Direction;

import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    private Stage stage;
    private Stage help;
    private Scene scene1;
    private Group root1;
    private Scene scene2;
    private Group root2;
    private Scene scene3;
    private Group root3;
    private Group rootHelp;
    private Scene sceneHelp;
    private int index;
    private GridPane pane;
    private static   Hero currentHero;
    private Label label;
    private Text data;
    private Scene scene4;
    private Group root4;
    private Scene scene5;
    private Group root5;
    private VBox heroes;
    private VBox heroesdata;
    private Stage help2;
    
	public void start(Stage primaryStage) throws Exception {
		stage=primaryStage;
		  try {
				Game.loadHeroes("Heroes.csv");
			} catch (IOException e) {
				
				ExceptionPrint(e.getMessage());
			}
		 
		stage.setTitle("Last Of Us");
		scene1=createScene1();
		scene2=createScene2();
		scene3=createScene3();
		scene4=createscene4();
	    scene5=createscene5();
		help=createHelpStage();
		
  
		stage.setScene(scene4);
		stage.setMaximized(true);;
		stage.show();
		
		
	}
	private Scene createScene1(){
		root1=new Group();
		Image startI =new Image("startGame.png");
		ImageView imageView=new ImageView(startI);
		root1.getChildren().add(imageView);
		Button startGame=new Button("Start Game");
		startGame.setLayoutX(700);
		startGame.setLayoutY(750);
		startGame.setScaleX(2);
		root1.getChildren().add(startGame);
		EventHandler<MouseEvent> switchToScene2=new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				
				stage.setScene(scene2);
				stage.setFullScreen(true);
				
			}
			
		};
		startGame.setOnMouseClicked(switchToScene2);
		Button helpB=new Button("How to play");
		helpB.setLayoutX(1000);
		helpB.setLayoutY(750);
		helpB.setScaleX(2);
		root1.getChildren().add(helpB);
		EventHandler<MouseEvent> howToPlay=new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				stage.requestFocus();
				help.setMaximized(true);
				help.show();	
			}
		};
		helpB.setOnMouseClicked(howToPlay);
		scene1=new Scene(root1,600,600);
		return scene1;
	}
	
	private Scene createScene2(){
		root2 = new Group();
		Image scene2background = new Image("scene2final.png");
		ImageView scene2backgroundi= new ImageView(scene2background );
		root2.getChildren().add(scene2backgroundi);
		
		TextField t = new TextField();
		String l = "Enter Your Name";
	    t.setPromptText(l);
	    t.setFocusTraversable(false);
	    t.setScaleX(3);
	    t.setScaleY(1.5);
	    t.setTranslateX(850);
	    t.setTranslateY(50);
	    root2.getChildren().add(t);
	    
	    Button Selectlehero=new Button("Please Select a hero:");
	    Selectlehero.setStyle("-fx-background-color: Black");
	    Selectlehero.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
	    Selectlehero.setScaleX(3);
	    Selectlehero.setScaleY(2);
	    Selectlehero.setLayoutX(130);
	    Selectlehero.setLayoutY(175);
	    Selectlehero.setOpacity(0.8);
	    root2.getChildren().add(Selectlehero);
	    
	    Image image = new Image("Ellie Williams.png");
	    ImageView imageView1 = new ImageView(image);
	    Button b1 = new Button();
	    b1.setGraphic(imageView1);
	    b1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
	    b1.setScaleX(0.35);
	    b1.setScaleY(0.4);
        b1.setLayoutX(-120);
        b1.setLayoutY(100);
       
     
        Label l1 =new Label("Name: Ellie Williams \nType:Medic \nAttack damage=15 \nMax HP=110\nAction points=6");
        l1.setTextFill(Color.WHITE);
        l1.setFont(new Font("Arial",30));
        l1.setLayoutX(0);
        l1.setLayoutY(420);
        l1.setScaleX(0.5);
        l1.setScaleY(0.5);
        root2.getChildren().add(b1);
        root2.getChildren().add(l1);
        
        Image image2 = new Image("Bill.png");
	    ImageView imageView2 = new ImageView(image2);
	    Button b2 = new Button();
	    b2.setGraphic(imageView2);
	    b2.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
	    b2.setScaleX(0.35);
	    b2.setScaleY(0.4);
	    b2.setLayoutX(120);
        b2.setLayoutY(100);
        Label l2 =new Label("Name: Bill \nType:Medic \nAttack damage=10 \nMax HP=100\nAction points=7");
        l2.setTextFill(Color.WHITE);
        l2.setFont(new Font("Arial",30));
        l2.setLayoutX(230);
        l2.setLayoutY(425);
        l2.setScaleX(0.5);
        l2.setScaleY(0.5);
        root2.getChildren().add(b2);
        root2.getChildren().add(l2);
        
        
        
	    Image image3 = new Image("Henry Burell.png");
	    ImageView imageView3 = new ImageView(image3);
	    Button b3 = new Button();
	   
	    b3.setGraphic(imageView3);
	    b3.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
	    b3.setScaleX(0.35);
	    b3.setScaleY(0.4);
	    b3.setLayoutX(350);
        b3.setLayoutY(100);
        
        Label l3 =new Label("Name: Henry Burell \nType:Medic \nAttack damage=15 \nMax HP=105\nAction points=6");
        l3.setTextFill(Color.WHITE);
        l3.setFont(new Font("Arial",30));
        l3.setLayoutX(475);
        l3.setLayoutY(425);
        l3.setScaleX(0.5);
        l3.setScaleY(0.5);
         root2.getChildren().add(b3);
         root2.getChildren().add(l3);
         
         
         
 	    Image image4 = new Image("Joel Miller.png");
 	    ImageView imageView4 = new ImageView(image4);
 	    Button b4 = new Button();
 	   
 	    b4.setGraphic(imageView4);
 	    b4.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
 	    b4.setScaleX(0.35);
 	    b4.setScaleY(0.4);
 	    b4.setLayoutX(600);
         b4.setLayoutY(100);
         Label l4 =new Label("Name: Joel Miller \nType:Fighter \nAttack damage=30 \nMax HP=140\nAction points=5");
         l4.setTextFill(Color.WHITE);
         l4.setFont(new Font("Arial",30));
         l4.setLayoutX(720);
         l4.setLayoutY(425);
         l4.setScaleX(0.5);
         l4.setScaleY(0.5);

         root2.getChildren().add(b4);
         root2.getChildren().add(l4); 
         
         Image image5 = new Image("David.png");
 	    ImageView imageView5 = new ImageView(image5);
 	    Button b5 = new Button();
 	    b5.setGraphic(imageView5);
 	    b5.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
 	    b5.setScaleX(0.35);
 	    b5.setScaleY(0.4);
 	    b5.setLayoutX(-120);
         b5.setLayoutY(440);
         Label l5 =new Label("Name: David \nType:Fighter \nAttack damage=35 \nMax HP=150\nAction points=4");
         l5.setTextFill(Color.WHITE);
         l5.setFont(new Font("Arial",30));
         l5.setLayoutX(0);
         l5.setLayoutY(760);
         l5.setScaleX(0.5);
         l5.setScaleY(0.5);
         root2.getChildren().add(b5);
         root2.getChildren().add(l5);
         
         
 	    Image image6 = new Image("Riley Abel.png");
 	    ImageView imageView6 = new ImageView(image6);
 	    Button b6 = new Button();
 	    b6.setGraphic(imageView6);
 	    b6.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
 	    b6.setScaleX(0.35);
 	    b6.setScaleY(0.4);
 	    b6.setLayoutX(120);
         b6.setLayoutY(440);
         Label l6 =new Label("Name: Riley Abel \nType:Explorer \nAttack damage=25 \nMax HP=90\nAction points=5");
         l6.setTextFill(Color.WHITE);
         l6.setFont(new Font("Arial",30));
         l6.setLayoutX(240);
         l6.setLayoutY(760);
         l6.setScaleX(0.5);
         l6.setScaleY(0.5);
         root2.getChildren().add(b6);
         root2.getChildren().add(l6);
         
         
         Image image7 = new Image("Tess.png");
 	    ImageView imageView7 = new ImageView(image7);
 	    Button b7 = new Button();
 	    b7.setGraphic(imageView7);
 	    b7.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
 	    b7.setScaleX(0.35);
 	    b7.setScaleY(0.4);
 	    b7.setLayoutX(350);
         b7.setLayoutY(440); 
         Label l7 =new Label("Name: Tess \nType:Explorer \nAttack damage=20 \nMax HP=80\nAction points=6");
         l7.setTextFill(Color.WHITE);
         l7.setFont(new Font("Arial",30));
         l7.setLayoutX(470);
         l7.setLayoutY(760);
         l7.setScaleX(0.5);
         l7.setScaleY(0.5);

         root2.getChildren().add(b7);
         root2.getChildren().add(l7);
         
         
         Image image8 = new Image("Tommy Miller.png");
 	    ImageView imageView8 = new ImageView(image8);
 	    Button b8 = new Button();
 	    b8.setGraphic(imageView8);
 	   b8.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
 	    b8.setScaleX(0.35);
 	    b8.setScaleY(0.4);
 	    b8.setLayoutX(600);
         b8.setLayoutY(440); 
         Label l8 =new Label("Name: Tommy Miller \nType:Explorer \nAttack damage=25 \nMax HP=95\nAction points=5");
         l8.setTextFill(Color.WHITE);
         l8.setFont(new Font("Arial",30));
         l8.setLayoutX(720);
         l8.setLayoutY(760);
         l8.setScaleX(0.5);
         l8.setScaleY(0.5);
         
         
         b1.setOnMouseEntered(e -> {
             b1.setScaleX(0.5);
             b1.setScaleY(0.5);
         });
         b1.setOnMouseExited(e -> {
             b1.setScaleX(0.4);
             b1.setScaleY(0.4);
         });
         
         b2.setOnMouseEntered(e -> {
             b2.setScaleX(0.5);
             b2.setScaleY(0.5);
         });
         b2.setOnMouseExited(e -> {
             b2.setScaleX(0.4);
             b2.setScaleY(0.4);
         });
         
         b3.setOnMouseEntered(e -> {
             b3.setScaleX(0.5);
             b3.setScaleY(0.5);
         });
         b3.setOnMouseExited(e -> {
             b3.setScaleX(0.4);
             b3.setScaleY(0.4);
         });
         
         b4.setOnMouseEntered(e -> {
             b4.setScaleX(0.5);
             b4.setScaleY(0.5);
         });
         b4.setOnMouseExited(e -> {
             b4.setScaleX(0.4);
             b4.setScaleY(0.4);
         });
         
         b5.setOnMouseEntered(e -> {
             b5.setScaleX(0.5);
             b5.setScaleY(0.5);
         });
         b5.setOnMouseExited(e -> {
             b5.setScaleX(0.4);
             b5.setScaleY(0.4);
         });
         
         b6.setOnMouseEntered(e -> {
             b6.setScaleX(0.5);
             b6.setScaleY(0.5);
         });
         b6.setOnMouseExited(e -> {
             b6.setScaleX(0.4);
             b6.setScaleY(0.4);
         });
         
         b7.setOnMouseEntered(e -> {
             b7.setScaleX(0.5);
             b7.setScaleY(0.5);
         });
         b7.setOnMouseExited(e -> {
             b7.setScaleX(0.4);
             b7.setScaleY(0.4);
         });
         
         b8.setOnMouseEntered(e -> {
             b8.setScaleX(0.5);
             b8.setScaleY(0.5);
         });
         b8.setOnMouseExited(e -> {
             b8.setScaleX(0.4);
             b8.setScaleY(0.4);
         });

         root2.getChildren().add(b8);
         root2.getChildren().add(l8);
         

         Button Con = new Button("Continue");
         Con.setStyle("-fx-background-color: red; -fx-shape: \"M 0 20 L 20 0 L 40 20 Q 40 30 30 40 Q 20 50 10 40 Q 0 30 0 20 Z\";");
         Con.setLayoutX(980);
         Con.setLayoutY(930);
         Con.setScaleX(2.5);
         Con.setScaleY(2.5);
         Con.setVisible(false);
         
         Con.setOnMouseEntered(e -> {
             Con.setScaleX(3.5);
             Con.setScaleY(3.5);
         });
         Con.setOnMouseExited(e -> {
             Con.setScaleX(2.5);
             Con.setScaleY(2.5);
             
            
         });
         
         
         Rectangle rectangle= new Rectangle();
  		VBox box =new VBox();
  		rectangle.setX(15);
  		rectangle.setY(15);
  		rectangle.setLayoutX(1480);
  		rectangle.setLayoutY(100);
  		rectangle.setWidth(500);
  		rectangle.setHeight(600);
  		rectangle.setOpacity(0.3);
  		rectangle.setFill(Color.DARKGREY);
  		box.getChildren().add(rectangle);
  		
         Label l9 = new Label("Fighter: Can attack as many \n times in a turn  without \n costing action points, for 1 turn \n  whenever a supply is used.");
         l9.setTextFill(Color.WHITE);
         l9.setFont(new Font("Arial",30));
         l9.setLayoutX(1500);
         l9.setLayoutY(150);
         Label l10 = new Label("Explorer:Allows the player to  \n be able to see the \n entirety of the map   for 1 turn \n  whenever a suply is used." );
         l10.setTextFill(Color.WHITE);
         l10.setFont(new Font("Arial",30));
         l10.setLayoutX(1500);
         l10.setLayoutY(350);
         Label l11 = new Label ("Medic:Can heal and restore \n health   to other heroes or \n themselves,  each process \n of healing  uses 1 supply.");
         l11.setTextFill(Color.WHITE);
         l11.setFont(new Font("Arial",30));
         l11.setLayoutX(1500);
         l11.setLayoutY(550);
         root2.getChildren().add(rectangle);
         root2.getChildren().addAll(l9,l10,l11);
         
       
 		
 		
         
         root2.getChildren().add(Con);
         
         EventHandler<MouseEvent> setstarthero1=new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				
				index=1;
				 Con.setVisible(true);
				 
			}
        		 
         };
         
         EventHandler<MouseEvent> setstarthero2=new EventHandler<MouseEvent>(){

 			@Override
 			public void handle(MouseEvent event) {
 				
 				
 				index=5;
 				Con.setVisible(true);
 				
 				
 			}
         		 
          };
          
          
          EventHandler<MouseEvent> setstarthero3=new EventHandler<MouseEvent>(){

  			@Override
  			public void handle(MouseEvent event) {
  				
  				index=7;
  				
  				Con.setVisible(true);
  				
  			}
          		 
           };
           
           
           EventHandler<MouseEvent> setstarthero4=new EventHandler<MouseEvent>(){

   			@Override
   			public void handle(MouseEvent event) {
   				
   				index=0;
   				
   				Con.setVisible(true);
   				
   			}
           		 
            };
            
            
            EventHandler<MouseEvent> setstarthero5=new EventHandler<MouseEvent>(){

    			@Override
    			public void handle(MouseEvent event) {
    				
    				index=6;
    				
    				Con.setVisible(true);
    				
    			}
            		 
             };
             
             
             EventHandler<MouseEvent> setstarthero6=new EventHandler<MouseEvent>(){

     			@Override
     			public void handle(MouseEvent event) {
     				
     				index=3;
     				Con.setVisible(true);
     				
     				
     			}
             		 
              };
              
              
              EventHandler<MouseEvent> setstarthero7=new EventHandler<MouseEvent>(){

      			@Override
      			public void handle(MouseEvent event) {
      				
      				index=2;
      				
      				Con.setVisible(true);
      				
      			}
              		 
               };
               
               
               EventHandler<MouseEvent> setstarthero8=new EventHandler<MouseEvent>(){

       			@Override
       			public void handle(MouseEvent event) {
       				
       				index=4;
       				Con.setVisible(true);
       				
       				
	}
               		 
                };
           		b1.setOnMouseClicked(setstarthero1);
           		b2.setOnMouseClicked(setstarthero2);
           		b3.setOnMouseClicked(setstarthero3);
           		b4.setOnMouseClicked(setstarthero4);
           		b5.setOnMouseClicked(setstarthero5);
           		b6.setOnMouseClicked(setstarthero6);
           		b7.setOnMouseClicked(setstarthero7);
           		b8.setOnMouseClicked(setstarthero8);
                
                
         
         
         
         EventHandler<MouseEvent> switchToScene3=new EventHandler<MouseEvent>(){
                     
                    	  
                    	 
 			@Override
 			public void handle(MouseEvent event) {
 			    currentHero=Game.availableHeroes.get(index);
 				label =new Label(currentHero.toString());
 				Game.startGame(currentHero);
 	 		 	refresh(pane);	 
 	 		    stage.setScene(scene3);
 		    	stage.show();
 	 			stage.setFullScreen(true);
 				
 			}
			
			
 			
         
 			
 		};
 		Con.setOnMouseClicked(switchToScene3);
 		
         
		scene2= new Scene(root2,600,600);
		
		
		
		return scene2;
	}
	private Scene createScene3(){
		root3=new Group();
		Image image=new Image("1111.jpg");
		ImageView background= new ImageView(image);
		root3.getChildren().add(background);
		 pane=new GridPane();
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
			Rectangle button=new Rectangle();
			button.setFill(Color.WHITE);
			button.setWidth(20);
			button.setHeight(32);
		    button.setOpacity(0.35);
			pane.add(button, i, j);;	
		}}
		pane.setHgap(2);
		pane.setVgap(2);
		
	    pane.setScaleX(3.5);
	    pane.setScaleY(1.8);
	    pane.setLayoutX(850);
	    pane.setLayoutY(250);

	 	Button cure=new Button("Cure");
    	cure.setLayoutX(1725);
    	cure.setLayoutY(800);
    	cure.setScaleX(5.4);
    	cure.setScaleY(2.8);
    	EventHandler<MouseEvent> cureTarget=new EventHandler<MouseEvent>(){

  			@Override
  			public void handle(MouseEvent event) {
  				
  				try {
					currentHero.cure();
				} catch (NoAvailableResourcesException | InvalidTargetException
						| NotEnoughActionsException e1) {
					ExceptionPrint(e1.getMessage());
					
				}
  				refresh(pane);
  			}
          		 
           };

        
		root3.getChildren().add(cure);
		cure.setOpacity(0.6);
		cure.setOnMouseClicked(cureTarget);
		Button attack=new Button("Attack");
		attack.setLayoutX(1720);
    	attack.setLayoutY(700);
    	attack.setScaleX(4.5);
    	attack.setScaleY(2.8);
    	EventHandler<MouseEvent> attackTarget=new EventHandler<MouseEvent>(){

  			@Override
  			public void handle(MouseEvent event) {
  				
  				try {
					currentHero.attack();
				} catch (NotEnoughActionsException | InvalidTargetException e) {
					ExceptionPrint(e.getMessage());
				}
  				refresh(pane);
  			}
          		 
           };
		root3.getChildren().add(attack);
		attack.setOpacity(0.6);
		attack.setOnMouseClicked(attackTarget);
		Button endTurn=new Button("End Turn");
		endTurn.setLayoutX(1720);
    	endTurn.setLayoutY(600);
    	endTurn.setScaleX(3.8);
    	endTurn.setScaleY(2.8);
    	EventHandler<MouseEvent> endTurnEvent=new EventHandler<MouseEvent>(){

  			@Override
  			public void handle(MouseEvent event) {
  				
  				try {
					Game.endTurn();
				} catch (NotEnoughActionsException | InvalidTargetException e) {
					// TODO Auto-generated catch block
					ExceptionPrint(e.getMessage());
				}
  				refresh(pane);
  			}
          		 
           };
		root3.getChildren().add(endTurn);
		endTurn.setOpacity(0.6);
		endTurn.setOnMouseClicked(endTurnEvent);
		Button use=new Button("Use Special");
		use.setLayoutX(1700);
    	use.setLayoutY(900);
    	use.setScaleX(2.9);
    	use.setScaleY(2.8);
    	EventHandler<MouseEvent> activateSpecail=new EventHandler<MouseEvent>(){

  			@Override
  			public void handle(MouseEvent event) {
  				
  				try {
					currentHero.useSpecial();
				} catch (NoAvailableResourcesException | InvalidTargetException e) {
				  ExceptionPrint(e.getMessage());
				}
  				refresh(pane);
  			}
          		 
           };
	    root3.getChildren().add(use);
	    use.setOpacity(0.6);
	    use.setOnMouseClicked(activateSpecail);
	    data=new Text();
	    data.setLayoutX(1600);
	    data.setLayoutY(100);
	    data.setFont(new Font("Arieal",28));
	    data.setFill(Color.WHITE);
	    root3.getChildren().add(data);
		root3.getChildren().add(pane);
		heroes=new VBox();
		heroes.setSpacing(-380);
		heroes.setLayoutX(-185);
		heroes.setLayoutY(10);
		root3.getChildren().add(heroes);
		
		heroesdata=new VBox();
		heroesdata.setSpacing(-50);
		heroesdata.setLayoutX(150);
		heroesdata.setLayoutY(175);
		
		Rectangle border =new Rectangle(30,30);
		VBox box =new VBox();
  		border.setX(15);
  		border.setY(15);
  		border.setLayoutX(1575);
  		border.setLayoutY(55);
  		border.setWidth(300);
  		border.setHeight(300);
  		border.setOpacity(0.3);
  		border.setFill(Color.DARKGREY);
  		box.getChildren().add(border);
		
		
		root3.getChildren().add(heroesdata);
		root3.getChildren().add(border);
		 
		scene3=new Scene(root3,900,600);
		   label =new Label();
		if(currentHero!=null){
			label.setText(currentHero.toString());
	    
	    label.setStyle("-fx-background-color: White");
	    label.setLayoutX(1675 );
	    label.setLayoutY(100);
	    label.setScaleX(2);
	    label.setScaleY(2);
	 label.setTextFill(Color.BLACK);
	 label.setOpacity(0.5); }
	 
	 
	 
	 
	 
	 
	 scene3.setOnKeyPressed(event -> {   
		 int startHP=currentHero.getCurrentHp();
		 
		    switch (event.getCode()) {
		        case W:
		       
		        try {
					currentHero.move(Direction.UP);
				} catch (Exception e) {
				//if(Game.map)
					ExceptionPrint(e.getMessage());
				}
		            
		            break;
		        case A:
		       
			    try {
					currentHero.move(Direction.LEFT);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					ExceptionPrint(e.getMessage());
				}
		            break;
		        case S:
		        	 
				       try {
							currentHero.move(Direction.DOWN);
						} catch (Exception e) {
							ExceptionPrint(e.getMessage());
						}
		            break;
		        case D:
		        	 
				       try {
							currentHero.move(Direction.RIGHT);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							ExceptionPrint(e.getMessage());
						}
		            break;
		            default:
		            	break;
		            
		        
		           
		            
		    }
		    
		    	int newHP=currentHero.getCurrentHp();
		    	if(newHP<startHP)
		    		ExceptionPrint("You moved to a trap!");
		   
		    refresh(pane);	        
		});

	     root3.getChildren().add(label);
	    
		return scene3;
		
		
 
	}
	private Stage createHelpStage(){
		help=new Stage();
		help.setTitle("How to play");
		rootHelp =new Group();
		Label l=new Label("(1) To move your hero up,down,right and left use w,s,d and a respectivly.\n\n"
				+ "(2) To attack select a zombie from the hero's adjacent cells but take care the zombie will defend.\n\n"
				+ "(3) To cure a zombie, the hero must use a vaccine and select a zombie from his adjacent cells\n so the zombie will be replaced by a hero.\n\n"
				+ "(4) To move,attack or cure the hero must have at least one action point.\n\n"
				+ "(5) Take care of traps in the map.\n\n"
				+ "(6) There are 3 types of Hero(Fighter,Medic,Explorer).\nEach type of hero has his own special ability for a turn but the hero must have a supply in his supply inventory.\n\n"
				+ "(7) Gameplay Flow:The player starts off in a 15x15 grid map with just one hero and 10 zombies. The player can only see\n the directly adjacent cells next to their pool of heroes."
				+ " The player then keeps taking his turn trying to collect vaccines,\n and cure or kill zombies. "
				+ "The game ends when the player has collected and used all vaccines or when all heroes \nhave been overwhelmed and defeated by the zombies."
				+ "The player only wins if he has successfully collected and used \n all vaccines and has 5 or more heroes alive.");
	   rootHelp.getChildren().add(l);
	   sceneHelp =new Scene(rootHelp,950,600);
	   help.setScene(sceneHelp);
	   return help;
	}
	
	
	private Stage createHelpStage2(){
		help2=new Stage();
		help2.setTitle("How to play");
		rootHelp =new Group();
		Label l=new Label("Made By:\n\n"
				+ "Ahmed AMIN\n\n"
				+ "Amr Negm\n\n"
				+ "Youssef Mansour\n\n"
				+ "Specialthanks:"
				+ "StackOverFlow");
				
	   rootHelp.getChildren().add(l);
	   sceneHelp =new Scene(rootHelp,950,600);
	   help.setScene(sceneHelp);
	   return help2;
	}
	public static void updateHeroes(VBox vbox){
		String s="";
		for(int i=0;i<Game.heroes.size();i++){
		if(Game.heroes.get(i) instanceof Fighter)
			s=s+"Type: Fighter";
		else if(Game.heroes.get(i) instanceof Medic)
			s=s+"Type: Medic";
		else if(Game.heroes.get(i) instanceof Explorer)
			s=s+"Type: Explorer";
		s=s+"Name: "+Game.heroes.get(i).getName()+"\nAttack damage= "+Game.heroes.get(i).getAttackDmg()
					+"\nMax HP= "+Game.heroes.get(i).getCurrentHp()+"\nAction points= "+Game.heroes.get(i).getActionsAvailable() ;
		Label l=new Label(s);
		vbox.getChildren().add(l);
		}
	}
	
	
	public	Scene createscene4(){
		root4=new Group();
		Image image=new Image("scene4.jpg");
		ImageView background =new ImageView(image);
		root4.getChildren().add(background);
	    Text text=new Text("YOU LOST!");
	    text.setLayoutX(900);
	    text.setLayoutY(200);
	    text.setScaleX(5);
	    text.setScaleY(5);
	    text.setFont(new Font("Arieal",28));
	    text.setFill(Color.WHITE);
	    Button exit =new Button();
	    exit.setText(" Quit Game");
	    exit.setScaleX(3);
	    exit.setScaleY(3);
	    exit.setLayoutX(600);
	    exit.setLayoutY(800);
	    
	    Button credits =new Button();
	    credits.setText(" Credits");
	    credits.setScaleX(4.5);
	    credits.setScaleY(3);
	    credits.setLayoutX(1300);
	    credits.setLayoutY(800);
	    
	    EventHandler<MouseEvent> exitgame=new EventHandler<MouseEvent>(){
            
      	  
       	 
 			@Override
 			public void handle(MouseEvent event) {
 			   stage.close();
 			}	
 		};
 		exit.setOnMouseClicked(exitgame);
 		EventHandler<MouseEvent> howToPlay=new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				stage.requestFocus();
				help2.setMaximized(true);
				help2.show();	
			}
		};
		credits.setOnMouseClicked(howToPlay);
	    root4.getChildren().add(exit);
	    root4.getChildren().add(credits);
	    
	    
	    root4.getChildren().add(text);
	   
		scene4=new Scene(root4,600,600);
		return scene4;
	}
	
	private Scene createscene5(){
		root5=new Group();
		Image image=new Image("scene5.jpg");
		ImageView background =new ImageView(image);
		root5.getChildren().add(background);
	    Text text1=new Text("You survived!");
	    text1.setLayoutX(900);
	    text1.setLayoutY(200);
	    text1.setScaleX(5);
	    text1.setScaleY(5);
	    text1.setFont(new Font("Arieal",28));
	    text1.setFill(Color.WHITESMOKE);
	    Button exit =new Button();
	    exit.setText(" Quit Game");
	    exit.setScaleX(3);
	    exit.setScaleY(3);
	    exit.setLayoutX(600);
	    exit.setLayoutY(800);
	    
	    Button credits =new Button();
	    credits.setText(" Credits");
	    credits.setScaleX(4.5);
	    credits.setScaleY(3);
	    credits.setLayoutX(1300);
	    credits.setLayoutY(800);
	    
	    EventHandler<MouseEvent> exitgame=new EventHandler<MouseEvent>(){
            
      	  
       	 
 			@Override
 			public void handle(MouseEvent event) {
 			   stage.close();
 			}	
 		};
 		exit.setOnMouseClicked(exitgame);
 		EventHandler<MouseEvent> howToPlay=new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				stage.requestFocus();
				help2.setMaximized(true);
				help2.show();	
			}
		};
		credits.setOnMouseClicked(howToPlay);
	    root5.getChildren().add(exit);
	    root5.getChildren().add(credits);
	    root5.getChildren().add(text1);
	    
	   
		scene5=new Scene(root5,600,600);
		return scene5;
	}
	public void refresh(GridPane pane){
		pane.getChildren().clear();
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
			Rectangle button=new Rectangle();
			if(Game.map[14-i][j].isVisible()==true){
			button.setFill(Color.WHITE);
			button.setWidth(20);
			button.setHeight(32);
		    button.setOpacity(0.35);}
			else{
				button.setFill(Color.BLACK);
				button.setWidth(20);
				button.setHeight(32);
			    button.setOpacity(0.50);
			    }
			
			pane.add(button,j, i);;
			
			
			}
			
				
		}
		pane.setHgap(2);
		pane.setVgap(2);
		
	    pane.setScaleX(3.5);
	    pane.setScaleY(1.8);
	    pane.setLayoutX(850);
	    pane.setLayoutY(250);

		    for(int i=0;i<15;i++){
		    	for(int j=0;j<15;j++){
		    		if(Game.map[i][j].isVisible()==true){
	 		    		if(Game.map[i][j] instanceof CharacterCell){
 		    			if(((CharacterCell)Game.map[i][j]).getCharacter() instanceof Zombie ){ 	
 		    			Zombie temp=(Zombie)((CharacterCell)Game.map[i][j]).getCharacter();
 		    			Point l=temp.getLocation();
		    		        int x=14-l.x;
		    		        int y=l.y;
 		    				Rectangle zombierec=new Rectangle(20,32);
 		    				Image zombieimg= new Image("Zombie.png"); 		 		    				
 		    				ImagePattern q= new ImagePattern(zombieimg);
	    				   zombierec.setFill(q);
		    				
	 		    				pane.add(zombierec, y, x);	

	 		    				 zombierec.setOnMouseClicked(event -> {

	 		    			
	 		    						if(Game.map[l.x][l.y] instanceof CharacterCell){
	 		    						      currentHero.setTarget(((CharacterCell)Game.map[l.x][l.y]).getCharacter());
	 		    						     // zombierec.setFill(Color.RED);
	 		    						      
	 		    						   
	 		    			        }});
	 		    				 
	 		    				
	 		    			 
	 		    				}
 		    			else if(((CharacterCell)Game.map[i][j]).getCharacter() instanceof Hero ){
 		    				Hero temp=(Hero)((CharacterCell)Game.map[i][j]).getCharacter();
 		    				Point l=temp.getLocation();
 		    		        int x=14-l.x;
 		    		        int y=l.y;
 		    		        String name=temp.getName();
 		    		        Rectangle heroc=new Rectangle(20,32);
 		    		       Image imagen=new Image(name+".png");
		    		        ImagePattern pnew=new ImagePattern(imagen);
		    		        heroc.setFill(pnew);
 		    		        pane.add(heroc, y, x);

 		    				 heroc.setOnMouseClicked(event -> {

 		    						
 		    						if(Game.map[y][14-x] instanceof CharacterCell){
 		    						      currentHero.setTarget(((CharacterCell)Game.map[l.x][l.y]).getCharacter());
 		    						    // heroc.setFill(Color.RED);
 		    			        }});
 		    				
 		    		        
 		    			}
 		    				
	 		    		}
	 		    		
	 		    		if(Game.map[i][j] instanceof CollectibleCell){
	 		    			if(((((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Supply))){
	 		    				Rectangle supply=new Rectangle(20,32);
	 		    				Image supplyimg=new Image("Supply.png");
	 		    				ImagePattern s=new ImagePattern(supplyimg);
	 		    				supply.setFill(s);
	 		    				pane.add(supply,j,14-i);
	 		    				
	 		    			}
	 		    			
	 		    			if((((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Vaccine)){
	 		    				Rectangle supply=new Rectangle(20,32);
	 		    				Image vaccineimg=new Image("Vaccine.png");
	 		    				ImagePattern v=new ImagePattern(vaccineimg);
	 		    				supply.setFill(v);
	 		    				pane.add(supply,j,14-i);
	 		    				
	 		    			}
	 		    		}
	 		    		
 		    	
		    	
 		    }
		    		
		    	}
 			 				 
}          
//            int yhero=-100;
            
            heroes.getChildren().clear();
            heroesdata.getChildren().clear();
		    for(int i=0;i<Game.heroes.size();i++){
		    	 
		       Button herobutton =new Button();
		       Hero temp=Game.heroes.get(i);
	    	   Image heroImage= new Image( Game.heroes.get(i).getName()+".png");
	    	   ImageView heroview=new ImageView(heroImage);
	    	   herobutton.setGraphic(heroview);
		   
		        herobutton.setOnMouseClicked(event -> {
		        	currentHero=temp;
		        	refresh(pane);
			        });
		    	herobutton.setScaleX(0.2);
		    	herobutton.setScaleY(0.2);
 	            herobutton.setLayoutX(-185);
//		        herobutton.setLayoutY(yhero);
	       
		        heroes.getChildren().add(herobutton);
		        
		        String s="Name: "+   Game.heroes.get(i).getName();
		   		if(currentHero instanceof Fighter)
		   			s=s+"\nType: Fighter"; 
		   		else if(currentHero instanceof Medic)
		   			s=s+"\nType: Medic"; 
		   		else if(currentHero instanceof Explorer)
		   			s=s+"\nType: Explorer"; 
		   		s=s+"\nCurrent HP: "+ Game.heroes.get(i).getCurrentHp()+"\nAttack Damage: "+ Game.heroes.get(i).getAttackDmg()+"\nMax  Action Points: "
		   			+ Game.heroes.get(i).getMaxActions();
		   		
		   		Label herodata=new Label(s);
		    	   herodata.setTextFill(Color.WHITE);
		    	   herodata.setScaleX(0.9);
		    	   herodata.setScaleY(0.6);
		    	   herodata.setLayoutX(1000);
		    	   
		           herodata.setFont(new Font("Arial",30));
//		           
		           heroesdata.getChildren().add(herodata);
		    }
		String s="Name: "+  currentHero.getName();
		if(currentHero instanceof Fighter)
			s=s+"\nType: Fighter"; 
		else if(currentHero instanceof Medic)
			s=s+"\nType: Medic"; 
		else if(currentHero instanceof Explorer)
			s=s+"\nType: Explorer"; 
		s=s+"\nCurrent HP: "+currentHero.getCurrentHp()+"\nAttack Damage: "+currentHero.getAttackDmg()+"\nAction Points: "
			+currentHero.getActionsAvailable()+ "\nSupply Inventory: "+currentHero.getSupplyInventory().size()+"\nVaccine Inventory "+currentHero.getVaccineInventory().size();
		data.setText(s);
		 
		if(Game.checkWin()==true){
			
			
			stage.setScene(scene5);
			stage.setMaximized(true);
			stage.show();
			
		}
		else{
			if(Game.checkGameOver()==true){
				stage.setScene(scene4);
				stage.show();
				stage.setMaximized(true);
			}
		}
		
		
		
	}
	
    public void ExceptionPrint(String s)
    {
    	Text pe = new Text(s);
    	pe.setLayoutX(800);
    	pe.setLayoutY(1000);
    	pe.setScaleX(2.5);
    	pe.setScaleY(2.5);
    	pe.setFill(Color.RED);
        pe.setFont(new Font("Arial",15));
        
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), pe);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(fadeEvent -> {
                StackPane parent = (StackPane) pe.getParent();
                parent.getChildren().remove(pe);
            });
            fadeOut.play();
        });
        pause.play();
    	root3.getChildren().add(pe);
    	
    }
	
	 
	public static void main(String[] args){
		
		
		  
		  
		launch(args);
	}
	
	

}