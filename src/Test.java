
public class Test {	
	public static void main(String[] args) {
		
		Joueur joueur = new Joueur() ;
		
		String[] reponse1 = {"Abidjan", "YamoussouKro", "Bingerville", "Korogho", "Je ne connais pas"} ;
		Question question1 = new Question("Quel est la capitale de la Cote d'Ivoire", reponse1, 0) ;
		
		
		String[] reponse2 = {"rouge", "orange", "vert", "jaune", "Je ne connais pas"} ;
		Question question2 = new Question("Quelle est la 1�re couleur du drapeau ivoirien ?", reponse2, 1) ;

		
		String[] reponse3 = {"Abidjan", "Yamoussoukro", "Man", "Grand-Bassam", "Je ne connais pas"} ;
		Question question3 = new Question("Quelle fut la 1�re capitale de la C�te d'Ivoire ?", reponse3, 3) ;

		String[] reponse4 = {"2000", "May 1999", "07 Ao�t 1960", "04 Juillet 1990", "Je ne connais pas"} ;
		Question question4 = new Question("Quand la C�te d'Ivoire a-t-elle eu son ind�pendance ?", reponse4, 3) ;
		
		String[] reponse5 = {"215", "57", "365", "512", "Je ne connais pas"} ;
		Question question5 = new Question("Quel est le nombre de jours dans une ann�e ? ", reponse5, 2); 

		String[] reponse6 = {"une maladie de plantes", "un programme ex�cutable", " monno-utilisateur", " mono-tache", "Je ne connais pas"} ;
		Question question6 = new Question("Le swollen-shoot est : ", reponse6, 0) ;

		String[] reponse7 = {"une instance d�un programme ex�cutable", "un programme ex�cutable", "Un contexte processeur", "1899", "Je ne connais pas"} ;
		Question question7 = new Question("Un processus est : ", reponse7, 1) ;
		
		String[] reponse8 = {"Google", "Unix", "Microsoft", "Yahoo", "Je ne connais pas"} ;
		Question question8 = new Question("Quelle entreprise finance le syst�me d�exploitation open source mobile Andro�d ?", reponse8, 0) ;

		String[] reponse9 = {"HP-UX", "Solaris", "RedHat", "SGI", "Je ne connais pas"} ;
		Question question9 = new Question("Parmi ces 4 syst�mes Unix, un est Linux, lequel ?", reponse9, 1) ;

		String[] reponse10 = {"un Moule", "une Tarte", "une Instance", "une Abstraction", "Je ne connais pas"} ;
		Question question10 = new Question("Qu'est-ce q'un objet en POO ?", reponse10, 2) ;

		String[] reponse11 = {"[192, 223]", "[1, 127]", "[224, 252]", "[128, 192]", "Je ne connais pas"} ;
		Question question11 = new Question("Quelle est la plage d'adresses de classe C dans un r�seau informatique ?", reponse11, 0) ;
		
		String[] reponse12 = {"11 degr�s", "58 degr�s", "101 degr�s", "100 degr�s", "Je ne connais pas"} ;
		Question question12 = new Question("L'eau boue � combien de degr� Celcius ?", reponse12, 3) ;
		
		String[] reponse13 = {"23 secondes", "120 secondes", "86400 secondes", "41600 secondes", "Je ne connais pas"} ;
		Question question13 = new Question("Combien de secondes font 3 jours ?", reponse13, 2) ;
		
		String[] reponse14 = {"le Nord", "le Sud", "CMU", "ESATIC", "Je ne connais pas"} ;
		Question question14 = new Question("Quel est le p�le des TIC en Afrique ?", reponse14, 3) ;
		
		String[] reponse15 = {"quitance", "question", "questionnaire", "Interrogation", "Je ne connais pas"} ;
		Question question15 = new Question(" Que signifie Quiz en Anglais ?", reponse15, 3) ;
		
		String[] reponse16 = {"Ode", "Avoiries", "Abidjanaise", "Vainqueur", "Je ne connais pas"} ;
		Question question16 = new Question("Quelle est l'hymne nationale de la C�te d'Ivoire ? ", reponse16, 2) ;
		
		String[] reponse17 = {"O", "U", "P", "W", "Je ne connais pas"} ;
		Question question17 = new Question("Quelle est la 21� lettre de l'aphabet?", reponse17, 1) ;
		
		String[] reponse18 = {"Br�sil", "Chine", "Japon", "Ghana", "Je ne connais pas"} ;
		Question question18 = new Question("Le pays le plus peupl� du monde", reponse18, 1) ;
		
		String[] reponse19 = {"2", "5", "4", "2", "Je ne connais pas"} ;
		Question question19 = new Question("Combien y-a-t-il de directions � l'ESATIC ?", reponse19, 4) ;
		
		String[] reponse20 = {"le vent", "le soleil", "la lumi�re", "1'eau", "Je ne connais pas"} ;
		Question question20 = new Question("La plus grande vitesse est celle de : ?", reponse20, 2) ;
		
		
		
		Question[] questions = {question1, question2, question3, question4, question5,
				question6, question7, question8, question9, question10, question11, question12, question13, question14, question15, question16, question17, question18, question19, question20} ;
		Fenetre fenetre = new Fenetre(questions,joueur);
	}
}
