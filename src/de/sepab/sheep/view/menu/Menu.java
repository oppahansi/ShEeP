package de.sepab.sheep.view.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu implements IMenu{
	private static JFrame jf = new JFrame ("ShEeP version pre-pre-alpha 0.0.0"); // das Fenster
	// alle menue screens
	public static JLabel lMainMenu = new JLabel(), 
						 lSinglePlayer = new JLabel(), 
						 lMultiPlayer = new JLabel(), 
						 lHighscore = new JLabel(), 
						 lOptions = new JLabel(),
						 lHelp = new JLabel();
	//alle buttons
	public static JButton mmbSinglePlayer = new JButton("Einzelspieler"), //mm = mainmenu & b=button
						  	mmbMultiPlayer = new JButton("Mehrspieler"),
						  	mmbOption = new JButton("Option"),
						  	mmbHighscore = new JButton("Highscore"),
						  	mmbHelp = new JButton("Hilfe"),
						  	mmbExit = new JButton("Beenden"),
						  	
						  mpbStart = new JButton("Start"), //sp = singleplayer
							mpbBack = new JButton("Zurück"),
									  	
						  spbStart = new JButton("Start"), //sp = singleplayer
						  	spbBack = new JButton("Zurück"),
						  	
						  hsbBack = new JButton("Zurück"), //hs = highscore
						  
						  obMinus = new JButton("-"),//o = options
						  	obPlus = new JButton("+"),
						  	obBack = new JButton("Zurück");
	//alle textfields
	public static JTextField sptfSingleplayer = new JTextField("Einzelspieler"),//tf = textfield
							 	sptfMap = new JTextField("Karte:"),
							 	sptfdifficulty = new JTextField("Schwierigkeit:"),
							 	sptfName = new JTextField("Name:"),
							 	sptfNameField = new JTextField(),
							 	sptfModus = new JTextField("Modus:"),
							 	
							 mptfMultiplayer = new JTextField("Mehrspieler"),// mp = multiplayer
							 	mptfMap = new JTextField("Karte:"),
							 	
							 hstfHighscore = new JTextField("Highscore"),
							 	hstfOnTime = new JTextField("Auf Zeit:"),
							 	hstfOTplayer1 = new JTextField("The_Dude"),
							 	hstfOTplayer2 = new JTextField("Pickachu"),
							 	hstfOTplayer3 = new JTextField("G. Newell"),
							 	hstfOTplayer1points = new JTextField("999 Punkte"),
								hstfOTplayer2points = new JTextField("998 Punkte"),
								hstfOTplayer3points = new JTextField("997 Punkte"),
								hstfOnNumber = new JTextField("Auf Anzahl:"),
								hstfONplayer1 = new JTextField("The_Dude"),
								hstfONplayer2 = new JTextField("Pickachu"),
								hstfONplayer3 = new JTextField("G. Newell"),
								hstfONplayer1points = new JTextField("999 Punkte"),
								hstfONplayer2points = new JTextField("998 Punkte"),
								hstfONplayer3points = new JTextField("997 Punkte"),
							
							otfOptions = new JTextField("Optionen"),
								otfMusic = new JTextField("Musik:"),
								otfMusicField = new JTextField("50"),
								
							htfHelp = new JTextField("Hilfe"); //h = help
	//alle textareas
	public static JTextArea htaHelp = new JTextArea();
	//alle fonts
	public static Font basicFont = new Font(Font.DIALOG, Font.PLAIN, 12),
					   headingFont = new Font(Font.DIALOG, Font.BOLD, 24);
	
	public static String[] spMap = {"Karte1","Karte2","Karte3"},
						   		spDifficulty ={"Einfach","Mittel","Schwer"},
						   		spModus = {"Auf Zeit", "Auf Anzahl"},
						   
						   mpMap = {"Karte1", "Karte2"};
	
	public static JComboBox spcbMap = new JComboBox(spMap),
								spcbDifficulty = new JComboBox(spDifficulty),
								spcbModus = new JComboBox(spModus),
							
							mpcbMap = new JComboBox(mpMap),
							
							hscbMap = new JComboBox(spMap);
							
		
	
	public static final int width = 640,
							height = 480;
	
	//Methode zum swtichen der screens
	public static void setCurrentLabel(JLabel label) {
		lMainMenu.setVisible(false);
		lHelp.setVisible(false);
		lHighscore.setVisible(false);
		lMultiPlayer.setVisible(false);
		lOptions.setVisible(false);
		lSinglePlayer.setVisible(false);
		label.setVisible(true);
	}
	
	public static void run() {
		jf.setFocusable(false);
		jf.setSize(width, height); //größe des screens
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		{//alle Font Deklarationen
			{//alle Button Fonts
				mmbSinglePlayer.setFont(basicFont);
			  	mmbMultiPlayer.setFont(basicFont);
			  	mmbOption.setFont(basicFont);
			  	mmbHighscore.setFont(basicFont);
			  	mmbHelp.setFont(basicFont);
			  	mmbExit.setFont(basicFont);
			  	
			  	spbStart.setFont(basicFont);
			  	spbBack.setFont(basicFont);
			  	
			  	mpbStart.setFont(basicFont);
			  	mpbBack.setFont(basicFont);
			  	
			  	hsbBack.setFont(basicFont);
			  	
			    obMinus.setFont(basicFont);
			  	obPlus.setFont(basicFont);
			  	obBack.setFont(basicFont);
			}
			
			{//alle tf Fonts
				sptfSingleplayer.setFont(headingFont);
			 	sptfMap.setFont(basicFont);
			 	sptfdifficulty.setFont(basicFont);
			 	sptfName.setFont(basicFont);
			 	sptfNameField.setFont(basicFont);
			 	sptfModus.setFont(basicFont);
			 	
			 	mptfMultiplayer.setFont(headingFont);
			 	mptfMap.setFont(basicFont);
			 	
			 	hstfHighscore.setFont(headingFont);
			 	hstfOnTime.setFont(basicFont);
			 	hstfOTplayer1.setFont(basicFont);
			 	hstfOTplayer2.setFont(basicFont);
			 	hstfOTplayer3.setFont(basicFont);
			 	hstfOTplayer1points.setFont(basicFont);
				hstfOTplayer2points.setFont(basicFont);
				hstfOTplayer3points.setFont(basicFont);
				hstfOnNumber.setFont(basicFont);
				hstfONplayer1.setFont(basicFont);
				hstfONplayer2.setFont(basicFont);
				hstfONplayer3.setFont(basicFont);
				hstfONplayer1points.setFont(basicFont);
				hstfONplayer2points.setFont(basicFont);
				hstfONplayer3points.setFont(basicFont);
			
				otfOptions.setFont(headingFont);
				otfMusic.setFont(basicFont);
				otfMusicField.setFont(basicFont);
				
				htfHelp.setFont(headingFont);
			}
			
			{
				spcbMap.setFont(basicFont);
				spcbDifficulty.setFont(basicFont);
				spcbModus.setFont(basicFont);
				
				mpcbMap.setFont(basicFont);
				hscbMap.setFont(basicFont);
			}
			
		}
		
		{//alle Positionen im Fenster
			{//alle b Positionen
				mmbSinglePlayer.setBounds((width)/2 - 100,105,200,40);
			  	mmbMultiPlayer.setBounds((width)/2 - 100,150,200,40);
			  	mmbOption.setBounds((width)/2 - 100,195,200,40);
			  	mmbHighscore.setBounds((width)/2 - 100,240,200,40);
			  	mmbHelp.setBounds((width)/2 - 100,285,200,40);
			  	mmbExit.setBounds((width)/2 - 100,330,200,40);
			  	
			  	spbStart.setBounds((width)/2 - 100,300,100,25);
			  	spbBack.setBounds((width)/2 - 100 + 100,300,100,25);
			  	
			  	mpbStart.setBounds((width)/2 - 100,150,100,25);
			  	mpbBack.setBounds((width)/2 - 100 + 100,150,100,25);
			  	
			  	hsbBack.setBounds(10,10,10,10);
			  	
			    obMinus.setBounds((width)/2 - 50 ,100,50,20);
			  	obPlus.setBounds((width)/2,100,50,20);
			  	obBack.setBounds((width)/2 - 50 ,150,100,20);
			}
			
		  	{//alle tf Positionen
		  		sptfSingleplayer.setBounds((width)/2 - 100,0,200,50);
			 	sptfMap.setBounds((width)/2 - 100 - 40,100,40,20);
			 	sptfdifficulty.setBounds((width)/2 - 100 - 85,150,85,20);
			 	sptfName.setBounds((width)/2 - 100 - 45,200,45,20);
			 	sptfNameField.setBounds((width)/2 - 100,200,200,20);
			 	sptfModus.setBounds((width)/2 - 100 - 50,250,50,20);
			 	
			 	mptfMultiplayer.setBounds((width)/2 - 100,0,200,50);
			 	mptfMap.setBounds((width)/2 - 100 - 40,100,40,20);
			 	
			 	hstfHighscore.setBounds((width)/2 - 100,0,200,50);
			 	hstfOnTime.setBounds((width)/2 - 100 - 100, 100, 100, 20);
			 	hstfOTplayer1.setBounds((width)/2 - 100 - 100, 130, 100, 20);
			 	hstfOTplayer2.setBounds((width)/2 - 100 - 100, 150, 100, 20);
			 	hstfOTplayer3.setBounds((width)/2 - 100 - 100, 170, 100, 20);
			 	hstfOTplayer1points.setBounds((width)/2, 130, 100, 20);
				hstfOTplayer2points.setBounds((width)/2, 150, 100, 20);
				hstfOTplayer3points.setBounds((width)/2, 170, 100, 20);
				hstfOnNumber.setBounds((width)/2 - 100 - 100, 220, 100, 20);
				hstfONplayer1.setBounds((width)/2 - 100 - 100, 250, 100, 20);
				hstfONplayer2.setBounds((width)/2 - 100 - 100, 270, 100, 20);
				hstfONplayer3.setBounds((width)/2 - 100 - 100, 290, 100, 20);
				hstfONplayer1points.setBounds((width)/2, 250, 100, 20);
				hstfONplayer2points.setBounds((width)/2, 270, 100, 20);
				hstfONplayer3points.setBounds((width)/2, 290, 100, 20);
			
				otfOptions.setBounds((width)/2 - 100,0,200,50);
				otfMusic.setBounds((width)/2 - 100,100,50,20);
				otfMusicField.setBounds((width)/2 + 50,100,50,20);
				
				htfHelp.setBounds(0,0,0,0);
		  	}
		  	
		  	{//cb
		  		spcbMap.setBounds((width)/2 - 100, 100, 200, 20);
		  		spcbDifficulty.setBounds((width)/2 - 100, 150, 200, 20);
		  		spcbModus.setBounds((width)/2 - 100, 250, 200, 20);
		  		
		  		mpcbMap.setBounds((width)/2 - 100, 100, 200, 20);
		  		
		  		hscbMap.setBounds((width)/2 - 100 + 100, 80, 100, 20);
		  	}
		}
		
		{//tf einstellungen
			sptfSingleplayer.setEditable(false);
			sptfSingleplayer.setBorder(BorderFactory.createEmptyBorder());
			sptfMap.setEditable(false);
			sptfMap.setBorder(BorderFactory.createEmptyBorder());
			sptfdifficulty.setEditable(false);
			sptfdifficulty.setBorder(BorderFactory.createEmptyBorder());
			sptfName.setEditable(false);
			sptfName.setBorder(BorderFactory.createEmptyBorder());
			sptfModus.setEditable(false);
			sptfModus.setBorder(BorderFactory.createEmptyBorder());
			
			mptfMultiplayer.setEditable(false);
			mptfMultiplayer.setBorder(BorderFactory.createEmptyBorder());
			mptfMap.setEditable(false);
			mptfMap.setBorder(BorderFactory.createEmptyBorder());
			
			otfOptions.setEditable(false);
			otfOptions.setBorder(BorderFactory.createEmptyBorder());
			otfMusic.setEditable(false);
			otfMusic.setBorder(BorderFactory.createEmptyBorder());
			
			hstfHighscore.setEditable(false);
			hstfHighscore.setBorder(BorderFactory.createEmptyBorder());
			hstfOnTime.setEditable(false);
			hstfOnTime.setBorder(BorderFactory.createEmptyBorder());
		 	hstfOTplayer1.setEditable(false);
		 	hstfOTplayer1.setBorder(BorderFactory.createEmptyBorder());
		 	hstfOTplayer2.setEditable(false);
		 	hstfOTplayer2.setBorder(BorderFactory.createEmptyBorder());
		 	hstfOTplayer3.setEditable(false);
		 	hstfOTplayer3.setBorder(BorderFactory.createEmptyBorder());
		 	hstfOTplayer1points.setEditable(false);
		 	hstfOTplayer1points.setBorder(BorderFactory.createEmptyBorder());
			hstfOTplayer2points.setEditable(false);
			hstfOTplayer2points.setBorder(BorderFactory.createEmptyBorder());
			hstfOTplayer3points.setEditable(false);
			hstfOTplayer3points.setBorder(BorderFactory.createEmptyBorder());
			hstfOnNumber.setEditable(false);
			hstfOnNumber.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer1.setEditable(false);
			hstfONplayer1.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer2.setEditable(false);
			hstfONplayer2.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer3.setEditable(false);
			hstfONplayer3.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer1points.setEditable(false);
			hstfONplayer1points.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer2points.setEditable(false);
			hstfONplayer2points.setBorder(BorderFactory.createEmptyBorder());
			hstfONplayer3points.setEditable(false);
			hstfONplayer3points.setBorder(BorderFactory.createEmptyBorder());
		}
		
		{//alle Button actionListener
			{//mm
				mmbSinglePlayer.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lSinglePlayer);
					}
				});
				mmbMultiPlayer.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lMultiPlayer);
					}
				});
				mmbOption.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lOptions);
					}
				});
				mmbHighscore.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lHighscore);
					}
				});
				mmbExit.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
			}
			
			{//sp
				spbStart.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				spbBack.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lMainMenu);
					}
				});
			}
			
			{//mp
				mpbStart.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				mpbBack.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lMainMenu);
					}
				});
			}
			
			{//o
				obMinus.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				obPlus.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				obBack.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lMainMenu);
					}
				});
			}
			
			{//hs
				hsbBack.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						setCurrentLabel(lMainMenu);
					}
				});
			}
			
			
		}
		
		{//das einfügen der elemente in die Labels
			{//mm
				lMainMenu.add(mmbExit);
				lMainMenu.add(mmbHelp);
				lMainMenu.add(mmbHighscore);
				lMainMenu.add(mmbMultiPlayer);
				lMainMenu.add(mmbOption);
				lMainMenu.add(mmbSinglePlayer);
			}
			
			{//sp
				lSinglePlayer.add(sptfSingleplayer);
				lSinglePlayer.add(sptfMap);
				lSinglePlayer.add(sptfdifficulty);
				lSinglePlayer.add(sptfName);
				lSinglePlayer.add(sptfNameField);
				lSinglePlayer.add(sptfModus);
				
				lSinglePlayer.add(spbStart);
				lSinglePlayer.add(spbBack);
				
				lSinglePlayer.add(spcbMap);
				lSinglePlayer.add(spcbDifficulty);
				lSinglePlayer.add(spcbModus);
			}
			
			{//mp
				lMultiPlayer.add(mpbStart);
				lMultiPlayer.add(mpbBack);
				
				lMultiPlayer.add(mptfMultiplayer);
				lMultiPlayer.add(mptfMap);
				
				lMultiPlayer.add(mpcbMap);
			}
			
			{//o
				lOptions.add(obMinus);
				lOptions.add(obPlus);
				lOptions.add(obBack);
				
				lOptions.add(otfOptions);
				lOptions.add(otfMusic);
				lOptions.add(otfMusicField);
			}
			
			{//hs
				lHighscore.add(hstfHighscore);
				lHighscore.add(hstfOnTime);
				lHighscore.add(hstfOnNumber);
				lHighscore.add(hstfOTplayer1);
				lHighscore.add(hstfOTplayer2);
				lHighscore.add(hstfOTplayer3);
				lHighscore.add(hstfOTplayer1points);
				lHighscore.add(hstfOTplayer2points);
				lHighscore.add(hstfOTplayer3points);
				lHighscore.add(hstfONplayer1);
				lHighscore.add(hstfONplayer2);
				lHighscore.add(hstfONplayer3);
				lHighscore.add(hstfONplayer1points);
				lHighscore.add(hstfONplayer2points);
				lHighscore.add(hstfONplayer3points);
				
				lHighscore.add(hscbMap);
				
				
			}
			
		}
		
		{//Label einstellen
			lMainMenu.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lSinglePlayer.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lMultiPlayer.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lOptions.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lHighscore.setBounds(0,0,jf.getWidth(),jf.getHeight());
		}
		
		{//Labels einfügen in das Fenster
			jf.add(lMainMenu);
			jf.add(lSinglePlayer);
			jf.add(lMultiPlayer);
			jf.add(lOptions);
			jf.add(lHighscore);
		}
		//startLabel initialisieren
		setCurrentLabel(lMainMenu);
		
		 
		 jf.setVisible(true);
	}
							
	
	
	
	
}
