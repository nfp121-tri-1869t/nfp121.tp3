package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        capacite = taille;
        stk = new Stack<Object>();
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (o == null) {
            throw new IllegalArgumentException("o ne peut pas être nul");
        }
        if (estPleine()) {
            throw new PilePleineException();
        }
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return stk.size() == capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = stk.size() - 1; i >= 0; i--) {
            Object item = stk.elementAt(i);
            if (item != null) {
                sb.append(item.toString());
                if (i > 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Pile2) {
            Pile2 pile = (Pile2)o;
            // Définit si les deux piles ont la même capacité et le même nombre d'éléments.
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            for (int i = stk.size() - 1; i >= 0; i--) {
                // Compare chaque élément depuis le sommet de chaque pile.
                Object a = stk.elementAt(i), b = pile.stk.elementAt(i);
                if (a != null) {
                    equals &= a.equals(b);
                } else {
                    equals = false;
                }                   
                if (!equals) {
                    // Si au moins il existe au moins une différence dans les deux piles c'est qu'elles ne sont pas égales, il n'est pas nécessaire de poursuivre la comparaison.
                    break;
                }
            }
        }
        return equals;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }

} // Pile2.java
