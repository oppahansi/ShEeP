package de.sepab.sheep.display;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.sepab.sheep.handler.IDataLoader;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IRandomGenerator;





public class Menu{
	
	
	
	private static JFrame jFrame = new JFrame ("ShEeP version pre-pre-alpha 0.0.1"); // das Fenster
	// alle menue screens
	public static JPanel panelMainMenu = new JPanel(), 
						 panelSinglePlayer = new JPanel(), 
						 panelMultiPlayer = new JPanel(), 
						 panellHighscore = new JPanel(), 
						 panelOptions = new JPanel(),
						 panelHelp = new JPanel();
	
	public static GameBoard gameBoard;
	//alle buttons
	public static JButton mainMenuButton_SinglePlayer = new JButton("Einzelspieler"), //mm = mainmenu & b=button
						  	mainMenuButton_MultiPlayer = new JButton("Mehrspieler"),
						  	mainMenuButton_Option = new JButton("Option"),
						  	mainMenuButton_Highscore = new JButton("Highscore"),
						  	mainMenuButton_Help = new JButton("Hilfe"),
						  	mainMenuButton_Exit = new JButton("Beenden"),
						  	
						  multiPlayerButton_Start = new JButton("Start"), //sp = singleplayer
							multiPlayerButton_Back = new JButton("Zurück"),
									  	
						  singlePlayerButton_Start = new JButton("Start"), //sp = singleplayer
						  	singlePlayerButton_Back = new JButton("Zurück"),
						  	
						  highscoreButton_Back = new JButton("Zurück"), //hs = highscore
						  
						  optionButton_Minus = new JButton("-"),//o = options
						  	optionButton_Plus = new JButton("+"),
						  	optionButton_Back = new JButton("Zurück"),
						  	
						  helpButton_Back = new JButton("Zurück");//h = help
	//alle textfields
	public static JTextField singlePlayerTextField_Singleplayer = new JTextField("Einzelspieler"),//tf = textfield
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
								
							helpTextField_Help = new JTextField("Hilfe"); 
	//alle textareas
	public static JTextArea helpTextArea_Help = new JTextArea(
			"Auf Zeit: \r\n"
			+ "In diesem Modus versucht der Spieler soviele Schafe wie möglich in \r\n"
			+ "einer gewissen Zeit einzufangen \r\n"
			+ "\r\n"
			+ "Auf Anzahl: \r\n"
			+ "In diesem Modus versucht der Spieler so schnell wie möglich eine \r\n"
			+ "gewisse Anzahl an schafen einzufangen"
			);
	//alle fonts
	public static Font basicFont = new Font(Font.DIALOG, Font.PLAIN, 12),
					   headingFont = new Font(Font.DIALOG, Font.BOLD, 24);
	
	public static String[] singlePlayerSelection_Map = {"Karte1","Karte2","Karte3"},
						   		singlePlayerSelection_Difficulty ={"Einfach","Mittel","Schwer"},
						   		singlePlayerSelection_Modus = {"Auf Zeit", "Auf Anzahl"},
						   
						   multiPlayerSelection_Map = {"Karte1", "Karte2"};
	
	public static JComboBox singlePlayerComboBox_Map = new JComboBox(singlePlayerSelection_Map),
								singlePlayerComboBox_Difficulty = new JComboBox(singlePlayerSelection_Difficulty),
								singlePlayerComboBox_Modus = new JComboBox(singlePlayerSelection_Modus),
							
							multiPlayerComboBox_Map = new JComboBox(multiPlayerSelection_Map);
							
							
		
	
	public static final int width = 640,
							height = 480;
	
	private static ILevel level;
	private static IRandomGenerator randomGenerator;
	private static IDataLoader dataLoader;
	//Methode zum swtichen der screens
	public static void setCurrentLabel(JPanel panel) {
		panelMainMenu.setVisible(false);
		panelHelp.setVisible(false);
		panellHighscore.setVisible(false);
		panelMultiPlayer.setVisible(false);
		panelOptions.setVisible(false);
		panelSinglePlayer.setVisible(false);
		if (gameBoard != null) {
			gameBoard.setVisible(false);
		}
		panel.setVisible(true);
	}
	
	public Menu(IDataLoader idl, Input input) {
		this.dataLoader = idl;
		jFrame.addKeyListener(input);
	}
	
	public static void setHighscore(){
		dataLoader.loadHighscore();
		int[] onTime = dataLoader.getTimeHighscores(), onCount = dataLoader.getCountHighscores();
		String[] onTimeName = dataLoader.getTimeNames(), onCountName = dataLoader.getCountNames();
		HighscoreTextField_OTplayer1points.setText(onTime[0] + " Punkte");
		HighscoreTextField_OTplayer2points.setText(onTime[1] + " Punkte");
		HighscoreTextField_OTplayer3points.setText(onTime[2] + " Punkte");
		HighscoreTextField_OTplayer1.setText(onTimeName[0]);
		HighscoreTextField_OTplayer2.setText(onTimeName[1]);
		HighscoreTextField_OTplayer3.setText(onTimeName[2]);
		HighscoreTextField_ONplayer1points.setText(onCount[0] + " Punkte");
		HighscoreTextField_ONplayer2points.setText(onCount[1] + " Punkte");
		HighscoreTextField_ONplayer3points.setText(onCount[2] + " Punkte");
		HighscoreTextField_ONplayer1.setText(onCountName[0]);
		HighscoreTextField_ONplayer2.setText(onCountName[1]);
		HighscoreTextField_ONplayer3.setText(onCountName[2]);
	}
	
	public static void run(ILevel ilevel, IRandomGenerator irandomGenerator) {
		
		
		
		level = ilevel;
		randomGenerator = irandomGenerator;
		
		gameBoard = new GameBoard(level, randomGenerator);
		jFrame.setFocusable(false);
		jFrame.setSize(width, height); //größe des screens
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jFrame.setUndecorated(true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize()  ;

		jFrame.setLocation( (d.width - jFrame.getSize().width ) / 2,
		               (d.height- jFrame.getSize().height) / 2 );
		
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
		  	}
		  	
		  	{//cb
		  		singlePlayerComboBox_Map.setBounds((width)/2 - 100, 100, 200, 20);
		  		singlePlayerComboBox_Difficulty.setBounds((width)/2 - 100, 150, 200, 20);
		  		singlePlayerComboBox_Modus.setBounds((width)/2 - 100, 250, 200, 20);
		  		
		  		multiPlayerComboBox_Map.setBounds((width)/2 - 100, 100, 200, 20);
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
						setCurrentLabel(gameBoard);
						gameBoard.repaint();
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
						setCurrentLabel(gameBoard);
						gameBoard.repaint();
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
		
		{//das einfügen der elemente in die Labels
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
			
		}
		
		{//Label einstellen
			panelMainMenu.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panelSinglePlayer.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panelMultiPlayer.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panelOptions.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panellHighscore.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			panelHelp.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
			
//			gb.setBounds(0, 0, jf.getWidth(), jf.getHeight());
		}
		
		{//Labels einfügen in das Fenster
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
		
		 
		 jFrame.setVisible(true);
	}
							
	
	
	
	
}
