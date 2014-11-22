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
						  	
						  hsbback = new JButton("Zurück"), //hs = highscore
						  
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
							 	hstfOTplayer1 = new JTextField(),
							 	hstfOTplayer2 = new JTextField(),
							 	hstfOTplayer3 = new JTextField(),
							 	hstfOTplayer1points = new JTextField(),
								hstfOTplayer2points = new JTextField(),
								hstfOTplayer3points = new JTextField(),
								hstfOnNumber = new JTextField("Auf Anzahl:"),
								hstfONplayer1 = new JTextField(),
								hstfONplayer2 = new JTextField(),
								hstfONplayer3 = new JTextField(),
								hstfONplayer1points = new JTextField(),
								hstfONplayer2points = new JTextField(),
								hstfONplayer3points = new JTextField(),
							
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
							
							mpcbMap = new JComboBox(mpMap);
							
		
	
	public static final int height = 640,
							width = 480;
	
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
		jf.setSize(height, width); //größe des screens
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
			  	
			  	hsbback.setFont(basicFont);
			  	
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
			}
			
		}
		
		{//alle Positionen im Fenster
			{//alle b Positionen
				mmbSinglePlayer.setBounds((width-40)/2,105,200,40);
			  	mmbMultiPlayer.setBounds((width-40)/2,150,200,40);
			  	mmbOption.setBounds((width-40)/2,195,200,40);
			  	mmbHighscore.setBounds((width-40)/2,240,200,40);
			  	mmbHelp.setBounds((width-40)/2,285,200,40);
			  	mmbExit.setBounds((width-40)/2,330,200,40);
			  	
			  	spbStart.setBounds((width-40)/2,300,100,25);
			  	spbBack.setBounds((width-40)/2 + 100,300,100,25);
			  	
			  	mpbStart.setBounds((width-40)/2,150,100,25);
			  	mpbBack.setBounds((width-40)/2 + 100,150,100,25);
			  	
			  	hsbback.setBounds(10,10,10,10);
			  	
			    obMinus.setBounds(10,10,10,10);
			  	obPlus.setBounds(10,10,10,10);
			  	
			  	obBack.setBounds(10,10,10,10);
			}
			
		  	{//alle tf Positionen
		  		sptfSingleplayer.setBounds((width-40)/2,0,200,50);
			 	sptfMap.setBounds((width-40)/2 - 40,100,40,20);
			 	sptfdifficulty.setBounds((width-40)/2 - 85,150,85,20);
			 	sptfName.setBounds((width-40)/2 - 45,200,45,20);
			 	sptfNameField.setBounds((width-40)/2,200,200,20);
			 	sptfModus.setBounds((width-40)/2 - 50,250,50,20);
			 	
			 	mptfMultiplayer.setBounds((width-40)/2,0,200,50);
			 	mptfMap.setBounds((width-40)/2 - 40,100,40,20);
			 	
			 	hstfHighscore.setBounds(0,0,0,0);
			 	hstfOnTime.setBounds(0,0,0,0);
			 	hstfOTplayer1.setBounds(0,0,0,0);
			 	hstfOTplayer2.setBounds(0,0,0,0);
			 	hstfOTplayer3.setBounds(0,0,0,0);
			 	hstfOTplayer1points.setBounds(0,0,0,0);
				hstfOTplayer2points.setBounds(0,0,0,0);
				hstfOTplayer3points.setBounds(0,0,0,0);
				hstfOnNumber.setBounds(0,0,0,0);
				hstfONplayer1.setBounds(0,0,0,0);
				hstfONplayer2.setBounds(0,0,0,0);
				hstfONplayer3.setBounds(0,0,0,0);
				hstfONplayer1points.setBounds(0,0,0,0);
				hstfONplayer2points.setBounds(0,0,0,0);
				hstfONplayer3points.setBounds(0,0,0,0);
			
				otfOptions.setBounds(0,0,0,0);
				otfMusic.setBounds(0,0,0,0);
				otfMusicField.setBounds(0,0,0,0);
				
				htfHelp.setBounds(0,0,0,0);
		  	}
		  	
		  	{
		  		spcbMap.setBounds((width-40)/2, 100, 200, 20);
		  		spcbDifficulty.setBounds((width-40)/2, 150, 200, 20);
		  		spcbModus.setBounds((width-40)/2, 250, 200, 20);
		  		
		  		mpcbMap.setBounds((width-40)/2, 100, 200, 20);
		  	}
		}
		
		{
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
			
		}
		
		{//Label einstellen
			lMainMenu.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lSinglePlayer.setBounds(0,0,jf.getWidth(),jf.getHeight());
		}
		
		{//Labels einfügen in das Fenster
			jf.add(lMainMenu);
			jf.add(lSinglePlayer);
			jf.add(lMultiPlayer);
		}
		//startLabel initialisieren
		setCurrentLabel(lMainMenu);
		
		 
		 jf.setVisible(true);
	}
							
	
	
	
	
}
