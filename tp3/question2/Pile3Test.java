package question2;

/**
 * Classe-test Pile3Test.
 * 
 * @author (Omar Kasabaki)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile3Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    private Pile3 p1;
    private Pile3 p2;
    private Pile3 p3;

    protected void setUp() {
        p1 = new Pile3();
        p2 = new Pile3();
        p3 = new Pile3(1);
    }

    public void test_capaciteNegative() {
        Pile3 pile = new Pile3(-1);
        assertEquals(pile.capacite(), PileI.CAPACITE_PAR_DEFAUT);
    }

    public void test_taille() throws Exception {
        assertEquals(p1.taille(), 0);
        p1.empiler(10);
        assertEquals(p1.taille(), 1);
    }

    public void test_capacite() {
        assertEquals(p1.capacite(), PileI.CAPACITE_PAR_DEFAUT);
        assertEquals(p2.capacite(), PileI.CAPACITE_PAR_DEFAUT);
    }

    public void test_estPleine() throws Exception {
        p3.empiler(1);
        assertTrue(p3.estPleine());
    }

    public void test_estVide() throws Exception {
        assertTrue(p1.estVide());
    }

    public void test_depiler() throws Exception {
        Object o1 = new Integer(15);
        Object o2 = new Integer(65);
        p1.empiler(o1);
        p1.empiler(o2);
        Object sommet = p1.depiler();
        assertEquals(o2, sommet);
        assertEquals(p1.taille(), 1);
    }

    public void test_sommet() throws Exception {
        Object o1 = new Integer(15);
        Object o2 = new Integer(65);
        p1.empiler(o1);
        p1.empiler(o2);
        Object sommet = p1.sommet();
        assertEquals(o2, sommet);
    }

    public void test_toString() throws Exception {
        p1.empiler(55);
        p1.empiler("foo");
        p1.empiler(99);
        assertEquals(p1.toString(), "[99, foo, 55]");
    }

    public void test_equals() throws Exception {
        Object o1 = new Integer(55);
        Object o2 = "foo";
        Object o3 = new Object();
        p1.empiler(o1);
        p2.empiler(o1);
        p1.empiler(o2);
        p2.empiler(o2);
        p1.empiler(o3);
        p2.empiler(o3);
        assertEquals(p1, p2);
    }
}
/**
 * Constructeur de la classe-test Pile3Test
 */
//public Pile3Test() {}

/**
 * Met en place les engagements.
 * 
 * Méthode appelée avant chaque appel de méthode de test.
 */
//protected void setUp() // throws java.lang.Exception
//{
// Initialisez ici vos engagements

//}

/**
 * Supprime les engagements
 * 
 * Méthode appelée après chaque appel de méthode de test.
 */
//protected void tearDown() // throws java.lang.Exception
//{
// Libérez ici les ressources engagées par setUp()
//}

/**
 * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
 * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
 * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
 * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
 * "Enregistrer une méthode de test".
 */