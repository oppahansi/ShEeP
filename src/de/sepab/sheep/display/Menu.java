package de.sepab.sheep.display;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import de.sepab.sheep.entities.Dog;
import de.sepab.sheep.entities.Sheep;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IDataLoader;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.IJukeBox;
import de.sepab.sheep.handler.JukeBox;
import de.sepab.sheep.logic.ICollision;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IMovement;
import de.sepab.sheep.logic.ITimer;
import de.sepab.sheep.logic.Level.GameModus;





public class Menu{

	private IJukeBox jukeBox = new JukeBox("/de/sepab/sheep/model/sfx/background.wav");

	private  JFrame jFrame = new JFrame ("ShEeP version pre-pre-alpha 0.0.1"); // das Fenster
	// alle menue screens
	public  JPanel panelMainMenu = new JPanel(), 
						 panelSinglePlayer = new JPanel(), 
						 panelMultiPlayer = new JPanel(), 
						 panellHighscore = new JPanel(), 
						 panelOptions = new JPanel(),
						 panelHelp = new JPanel();
	
	public  GameBoard gameBoard;
	//alle buttons
	public  JButton mainMenuButton_SinglePlayer = new JButton("Einzelspieler"), //mm = mainmenu & b=button
						  	mainMenuButton_MultiPlayer = new JButton("Mehrspieler"),
						  	mainMenuButton_Option = new JButton("Option"),
						  	mainMenuButton_Highscore = new JButton("Highscore"),
						  	mainMenuButton_Help = new JButton("Hilfe"),
						  	mainMenuButton_Exit = new JButton("Beenden"),
						  	
						  multiPlayerButton_Start = new JButton("Start"), //sp = singleplayer
							multiPlayerButton_Back = new JButton("Zur�ck"),
									  	
						  singlePlayerButton_Start = new JButton("Start"), //sp = singleplayer
						  	singlePlayerButton_Back = new JButton("Zur�ck"),
						  	
						  highscoreButton_Back = new JButton("Zur�ck"), //hs = highscore
						  
						  optionButton_Minus = new JButton("-"),//o = options
						  	optionButton_Plus = new JButton("+"),
						  	optionButton_Back = new JButton("Zur�ck"),
						  	
						  helpButton_Back = new JButton("Zur�ck");//h = help
	//alle textfields
	public  JTextField singlePlayerTextField_Singleplayer = new JTextField("Einzelspieler"),//tf = textfield
							 	singlePlayerTextField_Map = new JTextField("Karte:"),
							 	singlePlayerTextField_Difficulty = new JTextField("Schwierigkeit:"),
							 	singlePlayerTextField_Name = new JTextField("Name:"),
							 	singlePlayerTextField_NameField = new JTextField(),
							 	singlePlayerTextField_Modus = new JTextField("Modus:"),
							 	
							 multiPlayerTextField_Multiplayer = new JTextField("Mehrspieler"),// mp = multiplayer
							 	multiPlayerTextField_Map = new JTextField("Karte:"),
							 	
							 HighscoreTextField_Highscore = new JTextField("Highscore"),
							 	HighscoreTextField_OnTime = new JTextField("Auf Zeit:"),
							 	HighscoreTextField_OTplayer1 = new JTextField("The_Dude"),
							 	HighscoreTextField_OTplayer2 = new JTextField("Pickachu"),
							 	HighscoreTextField_OTplayer3 = new JTextField("G. Newell"),
							 	HighscoreTextField_OTplayer1points = new JTextField("999 Punkte"),
								HighscoreTextField_OTplayer2points = new JTextField("998 Punkte"),
								HighscoreTextField_OTplayer3points = new JTextField("997 Punkte"),
								HighscoreTextField_OnNumber = new JTextField("Auf Anzahl:"),
								HighscoreTextField_ONplayer1 = new JTextField("The_Dude"),
								HighscoreTextField_ONplayer2 = new JTextField("Pickachu"),
								HighscoreTextField_ONplayer3 = new JTextField("G. Newell"),
								HighscoreTextField_ONplayer1points = new JTextField("999 Punkte"),
								HighscoreTextField_ONplayer2points = new JTextField("998 Punkte"),
								HighscoreTextField_ONplayer3points = new JTextField("997 Punkte"),
							
							optionTextfield_Options = new JTextField("Optionen"),
								optionTextField_Music = new JTextField("Musik:"),
								optionTextfield_MusicField = new JTextField("50"),
								
							helpTextField_Help = new JTextField("Hilfe"),
							
							gameBoard_sheeps1 = new JTextField("Schafe:"),
								gameBoard_sheepcounter1 = new JTextField(),
								gameBoard_Time = new JTextField("00:00"),
								gameBoard_sheeps2 = new JTextField("Schafe:"),
								gameBoard_sheepcounter2 = new JTextField()
							;
	//alle textareas
	public  JTextArea helpTextArea_Help = new JTextArea(
			"Auf Zeit: \r\n"
			+ "In diesem Modus versucht der Spieler soviele Schafe wie m�glich in \r\n"
			+ "einer gewissen Zeit einzufangen \r\n"
			+ "\r\n"
			+ "Auf Anzahl: \r\n"
			+ "In diesem Modus versucht der Spieler so schnell wie m�glich eine \r\n"
			+ "gewisse Anzahl an schafen einzufangen"
			);
	//alle fonts
	public  Font basicFont = new Font(Font.DIALOG, Font.PLAIN, 12),
					   headingFont = new Font(Font.DIALOG, Font.BOLD, 24);
	
	public  String[] singlePlayerSelection_Map = {"Karte1","Karte2","Karte3"},
						   		singlePlayerSelection_Difficulty ={"Einfach","Mittel","Schwer"},
						   		singlePlayerSelection_Modus = {"Auf Zeit", "Auf Anzahl"},
						   
						   multiPlayerSelection_Map = {"Karte1", "Karte2"};
	
	public  ImageIcon[] singlePlayerSelection_MapIcon = {new ImageIcon(GameBoard.getImagesingleplayermap1()), 
														 new ImageIcon(GameBoard.getImagesingleplayermap2()), 
														 new ImageIcon(GameBoard.getImagesingleplayermap3())},
														 
						multiPlayerSelection_MapIcon = {new ImageIcon(GameBoard.getImagemultiplayermap1()), 
														new ImageIcon(GameBoard.getImagemultiplayermap2())};
	

	

	
	public Integer[] singlePlayerMapArray = {0,1,2},
					 multiPlayerMapArray = {0,1};
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  JComboBox singlePlayerComboBox_Map = new JComboBox(singlePlayerMapArray),
								singlePlayerComboBox_Difficulty = new JComboBox(singlePlayerSelection_Difficulty),
								singlePlayerComboBox_Modus = new JComboBox(singlePlayerSelection_Modus),
							
							multiPlayerComboBox_Map = new JComboBox(multiPlayerMapArray);
							
							
		
	
	public  final int width = 1280,
							height = 960	;
	
	public  ILevel level;
	private  IDataLoader dataLoader;
	public  GameModus gameModus;
	

	public  ICollision collision;
	public  IMovement movement;
	public  IInput input;
	public  javax.swing.Timer swingTimer;
	public   ITimer timer;
	public  AI ai;
	private Menu menu = this;
	private Dog dog = new Dog(0, 0, 1, 1, null, 1);
	private Sheep sheep = new Sheep(0, 0, 1, 1, 1);

	//Methode zum swtichen der screens
	public  void setCurrentLabel(JPanel panel) {
		panelMainMenu.setVisible(false);
		panelHelp.setVisible(false);
		panellHighscore.setVisible(false);
		panelMultiPlayer.setVisible(false);
		panelOptions.setVisible(false);
		panelSinglePlayer.setVisible(false);
		if (gameBoard != null) {
			gameBoard.setVisible(false);
		}
		if (panel == this.panellHighscore) {
			setHighscore();
		}
		panel.setVisible(true);
	}
	

	public Menu(IDataLoader idl) {
		this.dataLoader = idl;
	}
	
	public Menu(){
		
	}
	
	public void setGameModus(String gameModus){
		switch (gameModus) {
		case "Mehrspieler":
			this.gameModus = GameModus.MULTIPLAYER;
			break;
		case "Auf Zeit":
			this.gameModus = GameModus.ONTIME;
			break;
		case "Auf Anzahl":
			this.gameModus = GameModus.ONCOUNT;
			break;
		default:
			this.gameModus = GameModus.ONTIME;
			break;
		}
	}
	
	public void setDifficulty(String difficulty) {
		switch (difficulty) {
		case "Einfach":
			ai.setIq(50);
			ai.setScareLength(1);
			dog.setBarkLength(150);
			dog.setSpeed(4);
			dog.setPowerUpLife(5);
			sheep.setPowerUpLife(1);
			sheep.setScareSpeed(3);
			sheep.setSpeed(1);
			break;
		case "Mittel":
			ai.setIq(100);
			ai.setScareLength(2);
			dog.setBarkLength(100);
			dog.setSpeed(2);
			dog.setPowerUpLife(3);
			sheep.setPowerUpLife(3);
			sheep.setScareSpeed(1);
			sheep.setSpeed(1);
			break;
		case "Schwer":
			ai.setIq(100);
			ai.setScareLength(4);
			dog.setBarkLength(50);
			dog.setSpeed(2);
			dog.setPowerUpLife(3);
			sheep.setPowerUpLife(5);
			sheep.setScareSpeed(0);
			sheep.setSpeed(2);
			break;
		default:
			ai.setIq(50);
			ai.setScareLength(1);
			dog.setBarkLength(150);
			dog.setSpeed(4);
			dog.setPowerUpLife(5);
			sheep.setPowerUpLife(1);
			sheep.setScareSpeed(3);
			sheep.setSpeed(1);
			break;	
		}
	}
	
	public  void setHighscore(){
		dataLoader.loadHighscore();
		int[] onTime = dataLoader.getTimeHighscores(), onCount = dataLoader.getCountHighscores();
		String[] onTimeName = dataLoader.getTimeNames(), onCountName = dataLoader.getCountNames();
		HighscoreTextField_OTplayer1points.setText(onTime[2] + " Punkte");
		HighscoreTextField_OTplayer2points.setText(onTime[1] + " Punkte");
		HighscoreTextField_OTplayer3points.setText(onTime[0] + " Punkte");
		HighscoreTextField_OTplayer1.setText(onTimeName[2]);
		HighscoreTextField_OTplayer2.setText(onTimeName[1]);
		HighscoreTextField_OTplayer3.setText(onTimeName[0]);
		HighscoreTextField_ONplayer1points.setText(onCount[2] + " Punkte");
		HighscoreTextField_ONplayer2points.setText(onCount[1] + " Punkte");
		HighscoreTextField_ONplayer3points.setText(onCount[0] + " Punkte");
		HighscoreTextField_ONplayer1.setText(onCountName[2]);
		HighscoreTextField_ONplayer2.setText(onCountName[1]);
		HighscoreTextField_ONplayer3.setText(onCountName[0]);
	}
	
	@SuppressWarnings("unchecked")
	public void run() {
		
		
		{// ComboBox config
			ComboBoxRenderer singlePlayerMapRenderer = new ComboBoxRenderer(singlePlayerSelection_Map, singlePlayerSelection_MapIcon);
			singlePlayerComboBox_Map.setRenderer(singlePlayerMapRenderer);
			singlePlayerComboBox_Map.setMaximumRowCount(3);
			
			ComboBoxRenderer multiPlayerMapRenderer = new ComboBoxRenderer(multiPlayerSelection_Map, multiPlayerSelection_MapIcon);
			multiPlayerComboBox_Map.setRenderer(multiPlayerMapRenderer);
			multiPlayerComboBox_Map.setMaximumRowCount(2);
		}
		
		
		gameBoard = new GameBoard(level, input, menu);
		jFrame.setFocusable(false);
		jFrame.setSize(width, height); //gr��e des screens
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jFrame.setUndecorated(true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize()  ;

		jFrame.setLocation( (d.width - jFrame.getSize().width ) / 2,
		               (d.height - 20 - jFrame.getSize().height ) / 2 );
		
		{
			panelMainMenu.setLayout(null);
			panelSinglePlayer.setLayout(null);
			panelMultiPlayer.setLayout(null);
			panelOptions.setLayout(null);
			panellHighscore.setLayout(null);
			panelHelp.setLayout(null);
		}
		
		{//alle Font Deklarationen
			{//alle Button Fonts
				mainMenuButton_SinglePlayer.setFont(basicFont);
			  	mainMenuButton_MultiPlayer.setFont(basicFont);
			  	mainMenuButton_Option.setFont(basicFont);
			  	mainMenuButton_Highscore.setFont(basicFont);
			  	mainMenuButton_Help.setFont(basicFont);
			  	mainMenuButton_Exit.setFont(basicFont);
			  	
			  	singlePlayerButton_Start.setFont(basicFont);
			  	singlePlayerButton_Back.setFont(basicFont);
			  	
			  	multiPlayerButton_Start.setFont(basicFont);
			  	multiPlayerButton_Back.setFont(basicFont);
			  	
			  	highscoreButton_Back.setFont(basicFont);
			  	
			    optionButton_Minus.setFont(basicFont);
			  	optionButton_Plus.setFont(basicFont);
			  	optionButton_Back.setFont(basicFont);
			  	
			  	helpButton_Back.setFont(basicFont);
			}
			
			{//alle tf Fonts
				singlePlayerTextField_Singleplayer.setFont(headingFont);
			 	singlePlayerTextField_Map.setFont(basicFont);
			 	singlePlayerTextField_Difficulty.setFont(basicFont);
			 	singlePlayerTextField_Name.setFont(basicFont);
			 	singlePlayerTextField_NameField.setFont(basicFont);
			 	singlePlayerTextField_Modus.setFont(basicFont);
			 	
			 	multiPlayerTextField_Multiplayer.setFont(headingFont);
			 	multiPlayerTextField_Map.setFont(basicFont);
			 	
			 	HighscoreTextField_Highscore.setFont(headingFont);
			 	HighscoreTextField_OnTime.setFont(basicFont);
			 	HighscoreTextField_OTplayer1.setFont(basicFont);
			 	HighscoreTextField_OTplayer2.setFont(basicFont);
			 	HighscoreTextField_OTplayer3.setFont(basicFont);
			 	HighscoreTextField_OTplayer1points.setFont(basicFont);
				HighscoreTextField_OTplayer2points.setFont(basicFont);
				HighscoreTextField_OTplayer3points.setFont(basicFont);
				HighscoreTextField_OnNumber.setFont(basicFont);
				HighscoreTextField_ONplayer1.setFont(basicFont);
				HighscoreTextField_ONplayer2.setFont(basicFont);
				HighscoreTextField_ONplayer3.setFont(basicFont);
				HighscoreTextField_ONplayer1points.setFont(basicFont);
				HighscoreTextField_ONplayer2points.setFont(basicFont);
				HighscoreTextField_ONplayer3points.setFont(basicFont);
			
				optionTextfield_Options.setFont(headingFont);
				optionTextField_Music.setFont(basicFont);
				optionTextfield_MusicField.setFont(basicFont);
				
				helpTextField_Help.setFont(headingFont);
				
				gameBoard_sheeps1.setFont(basicFont);
				gameBoard_sheepcounter1.setFont(basicFont);
				gameBoard_Time.setFont(basicFont);
				gameBoard_sheeps2.setFont(basicFont);
				gameBoard_sheepcounter2.setFont(basicFont);
			}
			
			{//cb
				singlePlayerComboBox_Map.setFont(basicFont);
				singlePlayerComboBox_Difficulty.setFont(basicFont);
				singlePlayerComboBox_Modus.setFont(basicFont);
				
				multiPlayerComboBox_Map.setFont(basicFont);
				

			}
			
			{//ta
				helpTextArea_Help.setFont(basicFont);
			}
			
		}
		
		{//alle Positionen im Fenster
			{//alle b Positionen
				mainMenuButton_SinglePlayer.setBounds((width)/2 - 100,105,200,40);
			  	mainMenuButton_MultiPlayer.setBounds((width)/2 - 100,150,200,40);
			  	mainMenuButton_Option.setBounds((width)/2 - 100,195,200,40);
			  	mainMenuButton_Highscore.setBounds((width)/2 - 100,240,200,40);
			  	mainMenuButton_Help.setBounds((width)/2 - 100,285,200,40);
			  	mainMenuButton_Exit.setBounds((width)/2 - 100,330,200,40);
			  	
			  	singlePlayerButton_Start.setBounds((width)/2 - 100,300,100,25);
			  	singlePlayerButton_Back.setBounds((width)/2 - 100 + 100,300,100,25);
			  	
			  	multiPlayerButton_Start.setBounds((width)/2 - 100,150,100,25);
			  	multiPlayerButton_Back.setBounds((width)/2 - 100 + 100,150,100,25);
			  	
			  	highscoreButton_Back.setBounds((width)/2 - 100, 350, 100, 20);
			  	
			    optionButton_Minus.setBounds((width)/2 - 50 ,100,50,20);
			  	optionButton_Plus.setBounds((width)/2,100,50,20);
			  	optionButton_Back.setBounds((width)/2 - 50 ,150,100,20);
			  	
			  	helpButton_Back.setBounds((width/2) -50, 350, 100, 50);
			}
			
		  	{//alle tf Positionen
		  		singlePlayerTextField_Singleplayer.setBounds((width)/2 - 100,0,200,50);
			 	singlePlayerTextField_Map.setBounds((width)/2 - 100 - 40,100,40,20);
			 	singlePlayerTextField_Difficulty.setBounds((width)/2 - 100 - 85,150,85,20);
			 	singlePlayerTextField_Name.setBounds((width)/2 - 100 - 45,200,45,20);
			 	singlePlayerTextField_NameField.setBounds((width)/2 - 100,200,200,20);
			 	singlePlayerTextField_Modus.setBounds((width)/2 - 100 - 50,250,50,20);
			 	
			 	multiPlayerTextField_Multiplayer.setBounds((width)/2 - 100,0,200,50);
			 	multiPlayerTextField_Map.setBounds((width)/2 - 100 - 40,100,40,20);
			 	
			 	HighscoreTextField_Highscore.setBounds((width)/2 - 100,0,200,50);
			 	HighscoreTextField_OnTime.setBounds((width)/2 - 100 - 100, 100, 100, 20);
			 	HighscoreTextField_OTplayer1.setBounds((width)/2 - 100 - 100, 130, 100, 20);
			 	HighscoreTextField_OTplayer2.setBounds((width)/2 - 100 - 100, 150, 100, 20);
			 	HighscoreTextField_OTplayer3.setBounds((width)/2 - 100 - 100, 170, 100, 20);
			 	HighscoreTextField_OTplayer1points.setBounds((width)/2, 130, 100, 20);
				HighscoreTextField_OTplayer2points.setBounds((width)/2, 150, 100, 20);
				HighscoreTextField_OTplayer3points.setBounds((width)/2, 170, 100, 20);
				HighscoreTextField_OnNumber.setBounds((width)/2 - 100 - 100, 220, 100, 20);
				HighscoreTextField_ONplayer1.setBounds((width)/2 - 100 - 100, 250, 100, 20);
				HighscoreTextField_ONplayer2.setBounds((width)/2 - 100 - 100, 270, 100, 20);
				HighscoreTextField_ONplayer3.setBounds((width)/2 - 100 - 100, 290, 100, 20);
				HighscoreTextField_ONplayer1points.setBounds((width)/2, 250, 100, 20);
				HighscoreTextField_ONplayer2points.setBounds((width)/2, 270, 100, 20);
				HighscoreTextField_ONplayer3points.setBounds((width)/2, 290, 100, 20);
			
				optionTextfield_Options.setBounds((width)/2 - 100,0,200,50);
				optionTextField_Music.setBounds((width)/2 - 100,100,50,20);
				optionTextfield_MusicField.setBounds((width)/2 + 50,100,50,20);
				
				helpTextField_Help.setBounds((width)/2 - 100,0,200,50);
				
				gameBoard_sheeps1.setBounds(20,height,50, 20);
				gameBoard_sheepcounter1.setBounds(70,height,50, 20);
				gameBoard_Time.setBounds(width/2 - 100,height,200, 20);
				gameBoard_sheeps2.setBounds(width - 120,height,50, 20);
				gameBoard_sheepcounter2.setBounds(width - 70,height,50, 20);
		  	}
		  	
		  	{//cb
		  		singlePlayerComboBox_Map.setBounds((width)/2 - 100, 100, 200, 40);
		  		singlePlayerComboBox_Difficulty.setBounds((width)/2 - 100, 150, 200, 20);
		  		singlePlayerComboBox_Modus.setBounds((width)/2 - 100, 250, 200, 20);
		  		
		  		multiPlayerComboBox_Map.setBounds((width)/2 - 100, 100, 200, 40);
		  	}
		  	
		  	{//ta
		  		helpTextArea_Help.setBounds((width)/2 - 200, 100, 400, 200);
		  	}
		}
		
		{//tf einstellungen
			singlePlayerTextField_Singleplayer.setEditable(false);
			singlePlayerTextField_Singleplayer.setBorder(BorderFactory.createEmptyBorder());
			singlePlayerTextField_Map.setEditable(false);
			singlePlayerTextField_Map.setBorder(BorderFactory.createEmptyBorder());
			singlePlayerTextField_Difficulty.setEditable(false);
			singlePlayerTextField_Difficulty.setBorder(BorderFactory.createEmptyBorder());
			singlePlayerTextField_Name.setEditable(false);
			singlePlayerTextField_Name.setBorder(BorderFactory.createEmptyBorder());
			singlePlayerTextField_Modus.setEditable(false);
			singlePlayerTextField_Modus.setBorder(BorderFactory.createEmptyBorder());
			
			multiPlayerTextField_Multiplayer.setEditable(false);
			multiPlayerTextField_Multiplayer.setBorder(BorderFactory.createEmptyBorder());
			multiPlayerTextField_Map.setEditable(false);
			multiPlayerTextField_Map.setBorder(BorderFactory.createEmptyBorder());
			
			optionTextfield_Options.setEditable(false);
			optionTextfield_Options.setBorder(BorderFactory.createEmptyBorder());
			optionTextField_Music.setEditable(false);
			optionTextField_Music.setBorder(BorderFactory.createEmptyBorder());
			
			HighscoreTextField_Highscore.setEditable(false);
			HighscoreTextField_Highscore.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_OnTime.setEditable(false);
			HighscoreTextField_OnTime.setBorder(BorderFactory.createEmptyBorder());
		 	HighscoreTextField_OTplayer1.setEditable(false);
		 	HighscoreTextField_OTplayer1.setBorder(BorderFactory.createEmptyBorder());
		 	HighscoreTextField_OTplayer2.setEditable(false);
		 	HighscoreTextField_OTplayer2.setBorder(BorderFactory.createEmptyBorder());
		 	HighscoreTextField_OTplayer3.setEditable(false);
		 	HighscoreTextField_OTplayer3.setBorder(BorderFactory.createEmptyBorder());
		 	HighscoreTextField_OTplayer1points.setEditable(false);
		 	HighscoreTextField_OTplayer1points.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_OTplayer2points.setEditable(false);
			HighscoreTextField_OTplayer2points.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_OTplayer3points.setEditable(false);
			HighscoreTextField_OTplayer3points.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_OnNumber.setEditable(false);
			HighscoreTextField_OnNumber.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer1.setEditable(false);
			HighscoreTextField_ONplayer1.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer2.setEditable(false);
			HighscoreTextField_ONplayer2.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer3.setEditable(false);
			HighscoreTextField_ONplayer3.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer1points.setEditable(false);
			HighscoreTextField_ONplayer1points.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer2points.setEditable(false);
			HighscoreTextField_ONplayer2points.setBorder(BorderFactory.createEmptyBorder());
			HighscoreTextField_ONplayer3points.setEditable(false);
			HighscoreTextField_ONplayer3points.setBorder(BorderFactory.createEmptyBorder());
			
			helpTextField_Help.setEditable(false);
			helpTextField_Help.setBorder(BorderFactory.createEmptyBorder());
			helpTextArea_Help.setEditable(false);
			helpTextArea_Help.setBorder(BorderFactory.createEmptyBorder());
			
			gameBoard_sheeps1.setEditable(false);
			gameBoard_sheeps1.setBackground(Color.WHITE);
			gameBoard_sheeps1.setBorder(BorderFactory.createEmptyBorder());
			gameBoard_sheepcounter1.setEditable(false);
			gameBoard_sheepcounter1.setBorder(BorderFactory.createEmptyBorder());
			gameBoard_sheepcounter1.setBackground(Color.WHITE);
			gameBoard_Time.setEditable(false);
			gameBoard_Time.setBorder(BorderFactory.createEmptyBorder());
			gameBoard_Time.setBackground(Color.WHITE);
			gameBoard_Time.setHorizontalAlignment(SwingConstants.CENTER);
			gameBoard_sheeps2.setEditable(false);
			gameBoard_sheeps2.setBorder(BorderFactory.createEmptyBorder());
			gameBoard_sheeps2.setBackground(Color.WHITE);
			gameBoard_sheepcounter2.setEditable(false);
			gameBoard_sheepcounter2.setBorder(BorderFactory.createEmptyBorder());
			gameBoard_sheepcounter2.setBackground(Color.WHITE);
		}
		
		{//alle Button actionListener
			{//mm
				mainMenuButton_SinglePlayer.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelSinglePlayer);
					}
				});
				mainMenuButton_MultiPlayer.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelMultiPlayer);
					}
				});
				mainMenuButton_Option.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelOptions);
					}
				});
				mainMenuButton_Highscore.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setHighscore();
						setCurrentLabel(panellHighscore);
					}
				});
				mainMenuButton_Help.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelHelp);
					}
				});
				mainMenuButton_Exit.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
			}
			
			{//sp
					singlePlayerButton_Start.addActionListener(new ActionListener() {
					
						public void actionPerformed(ActionEvent arg0) {
							gameBoard_sheepcounter2.setVisible(false);
							gameBoard_sheeps2.setVisible(false);
							setDifficulty((String)singlePlayerComboBox_Difficulty.getSelectedItem());
							setGameModus((String)singlePlayerComboBox_Modus.getSelectedItem());
							level.getReferences(ai, gameBoard, timer, input, collision, menu, singlePlayerTextField_NameField.getText(), getGameModus());
							gameBoard.loadMap(singlePlayerComboBox_Map.getSelectedIndex(), singlePlayerComboBox_Modus.getSelectedIndex());
							gameBoard.Update(level);
							gameBoard.shuffle();
							setCurrentLabel(gameBoard);
							level.TimerStart();
							gameBoard.requestFocus();
							jFrame.setSize(width, height + 20);
							jukeBox.play();
						}
					});
					singlePlayerButton_Back.addActionListener(new ActionListener() {
					
						public void actionPerformed(ActionEvent arg0) {
							setCurrentLabel(panelMainMenu);
						}
					});
			}
			
			{//mp
				multiPlayerButton_Start.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						gameBoard_sheepcounter2.setVisible(true);
						gameBoard_sheeps2.setVisible(true);
						setDifficulty("Mehrspieler");
						setGameModus("Mehrspieler");
						level.getReferences(ai, gameBoard, timer, input, collision, menu, null, getGameModus());
						gameBoard.Update(level);
						gameBoard.loadMap(multiPlayerComboBox_Map.getSelectedIndex() + 3, 2);
						gameBoard.shuffle();
						setCurrentLabel(gameBoard);
						level.TimerStart();
						gameBoard.requestFocus();
						jFrame.setSize(width, height + 20);
						jukeBox.play();
					}
				});
				multiPlayerButton_Back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelMainMenu);
					}
				});
			}
			
			{//o
				optionButton_Minus.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				optionButton_Plus.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				optionButton_Back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelMainMenu);
					}
				});
			}
			
			{//hs
				highscoreButton_Back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelMainMenu);
					}
				});
			}
			
			{//h
				helpButton_Back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(panelMainMenu);
					}
				});
			}
			
			
		}
		
		{//das einf�gen der elemente in die Labels
			{//mm
				panelMainMenu.add(mainMenuButton_Exit);
				panelMainMenu.add(mainMenuButton_Help);
				panelMainMenu.add(mainMenuButton_Highscore);
				panelMainMenu.add(mainMenuButton_MultiPlayer);
				panelMainMenu.add(mainMenuButton_Option);
				panelMainMenu.add(mainMenuButton_SinglePlayer);
			}
			
			{//sp
				panelSinglePlayer.add(singlePlayerTextField_Singleplayer);
				panelSinglePlayer.add(singlePlayerTextField_Map);
				panelSinglePlayer.add(singlePlayerTextField_Difficulty);
				panelSinglePlayer.add(singlePlayerTextField_Name);
				panelSinglePlayer.add(singlePlayerTextField_NameField);
				panelSinglePlayer.add(singlePlayerTextField_Modus);
				
				panelSinglePlayer.add(singlePlayerButton_Start);
				panelSinglePlayer.add(singlePlayerButton_Back);
				
				panelSinglePlayer.add(singlePlayerComboBox_Map);
				panelSinglePlayer.add(singlePlayerComboBox_Difficulty);
				panelSinglePlayer.add(singlePlayerComboBox_Modus);
			}
			
			{//mp
				panelMultiPlayer.add(multiPlayerButton_Start);
				panelMultiPlayer.add(multiPlayerButton_Back);
				
				panelMultiPlayer.add(multiPlayerTextField_Multiplayer);
				panelMultiPlayer.add(multiPlayerTextField_Map);
				
				panelMultiPlayer.add(multiPlayerComboBox_Map);
			}
			
			{//o
				panelOptions.add(optionButton_Minus);
				panelOptions.add(optionButton_Plus);
				panelOptions.add(optionButton_Back);
				
				panelOptions.add(optionTextfield_Options);
				panelOptions.add(optionTextField_Music);
				panelOptions.add(optionTextfield_MusicField);
			}
			
			{//hs
				panellHighscore.add(highscoreButton_Back);
				
				panellHighscore.add(HighscoreTextField_Highscore);
				panellHighscore.add(HighscoreTextField_OnTime);
				panellHighscore.add(HighscoreTextField_OnNumber);
				panellHighscore.add(HighscoreTextField_OTplayer1);
				panellHighscore.add(HighscoreTextField_OTplayer2);
				panellHighscore.add(HighscoreTextField_OTplayer3);
				panellHighscore.add(HighscoreTextField_OTplayer1points);
				panellHighscore.add(HighscoreTextField_OTplayer2points);
				panellHighscore.add(HighscoreTextField_OTplayer3points);
				panellHighscore.add(HighscoreTextField_ONplayer1);
				panellHighscore.add(HighscoreTextField_ONplayer2);
				panellHighscore.add(HighscoreTextField_ONplayer3);
				panellHighscore.add(HighscoreTextField_ONplayer1points);
				panellHighscore.add(HighscoreTextField_ONplayer2points);
				panellHighscore.add(HighscoreTextField_ONplayer3points);
				
			}
			
			{//h
				panelHelp.add(helpButton_Back);
				
				panelHelp.add(helpTextField_Help);
				panelHelp.add(helpTextArea_Help);
			}
			
			{//gb
				gameBoard.add(gameBoard_Time);
				gameBoard.add(gameBoard_sheepcounter1);
				gameBoard.add(gameBoard_sheepcounter2);
				gameBoard.add(gameBoard_sheeps1);
				gameBoard.add(gameBoard_sheeps2);
			}
			
		}
		
		{//Label einstellen
			panelMainMenu.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
			panelSinglePlayer.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
			panelMultiPlayer.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
			panelOptions.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panellHighscore.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panelHelp.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			
//			gb.setBounds(0, 0, jf.getWidth(), jf.getHeight());
		}
		
		{//Labels einf�gen in das Fenster
			jFrame.add(panelMainMenu);
			jFrame.add(panelSinglePlayer);
			jFrame.add(panelMultiPlayer);
			jFrame.add(panelOptions);
			jFrame.add(panellHighscore);
			jFrame.add(panelHelp);
			jFrame.add(gameBoard);
//			jf.add(gb);
		}
		//startLabel initialisieren
		setCurrentLabel(panelMainMenu);
		
//		jFrame.addKeyListener((Input) input);
//		jFrame.requestFocus();
		 
		 jFrame.setVisible(true);
	}

	public  AI getAi() {
		return ai;
	}

	public  void setAi(AI ai) {
		this.ai = ai;
	}

	public  GameBoard getGameBoard() {
		return gameBoard;
	}

	public  void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public  ILevel getLevel() {
		return level;
	}

	public  void setLevel(ILevel level) {
		this.level = level;
	}

	public  IDataLoader getDataLoader() {
		return dataLoader;
	}

	public  void setDataLoader(IDataLoader dataLoader) {
		this.dataLoader = dataLoader;
	}

	public  GameModus getGameModus() {
		return gameModus;
	}

	public  void setGameModus(GameModus gameModus) {
		this.gameModus = gameModus;
	}

	public  ICollision getCollision() {
		return collision;
	}

	public  void setCollision(ICollision collision) {
		this.collision = collision;
	}

	public  IMovement getMovement() {
		return movement;
	}

	public  void setMovement(IMovement movement) {
		this.movement = movement;
	}

	public  IInput getInput() {
		return input;
	}

	public  void setInput(IInput input) {
		this.input = input;
	}

	public  javax.swing.Timer getSwingTimer() {
		return swingTimer;
	}

	public  void setSwingTimer(javax.swing.Timer swingTimer) {
		this.swingTimer = swingTimer;
	}

	public  ITimer getTimer() {
		return timer;
	}

	public  void setTimer(ITimer timer) {
		this.timer = timer;
	}

	public  int getWidth() {
		return width;
	}

	public  int getHeight() {
		return height;
	}
	
	public void setGameBoardTime(int time){
		gameBoard_Time.setText(time + "");
	}
	
	public void setGameBoardSheep1(int sheep){
		gameBoard_sheepcounter1.setText(sheep + "");
	}
	
	public void setGameBoardSheep2(int sheep){
		gameBoard_sheepcounter2.setText(sheep + "");
	}
							
	 public Dog getDog() {
		return dog;
	}


	public void setDog(Dog dog) {
		this.dog = dog;
	}


	public Sheep getSheep() {
		return sheep;
	}


	public void setSheep(Sheep sheep) {
		this.sheep = sheep;
	}

	public IJukeBox getJukeBox() {
		return jukeBox;
	}


	public void setJukeBox(IJukeBox jukeBox) {
		this.jukeBox = jukeBox;
	}

	@SuppressWarnings({ "serial", "rawtypes" })
	class ComboBoxRenderer extends JLabel
     implements ListCellRenderer {
		  private String[] listString;
		  private ImageIcon[] images;

		  public ComboBoxRenderer(String[] listString, ImageIcon[] images) {
			  setOpaque(true);
			  setHorizontalAlignment(CENTER);
			  setVerticalAlignment(CENTER);
			  this.listString = listString;
			  this.images = images;
		  }

		  /*
		   * This method finds the image and text corresponding
		   * to the selected value and returns the label, set up
		   * to display the text and image.
		   */
		  public Component getListCellRendererComponent(
                     JList list,
                     Object value,
                     int index,
                     boolean isSelected,
                     boolean cellHasFocus) {
			  //Get the selected index. (The index param isn't
			  //always valid, so just use the value.)
			  
			  int selectedIndex = ((Integer)value).intValue();
			  
			  if (isSelected) {
				  setBackground(list.getSelectionBackground());
				  setForeground(list.getSelectionForeground());
			  } else {
				  setBackground(list.getBackground());
				  setForeground(list.getForeground());
			  }

			  //Set the icon and text.  If icon was null, say so.
			  ImageIcon icon = images[selectedIndex];
			  String pet = listString[selectedIndex];
			  setIcon(icon);
			  if (icon != null) {
				  setText(pet);
				  setFont(list.getFont());
			  } else {
//				  setUhOhText(pet + " (no image available)",
//    			  list.getFont());
			  }return this;
		  }
	 }
	
	
	
}
