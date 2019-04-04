package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (Omar Kasabaki)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        zone = new Object[taille];
        ptr = 0;
    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (o == null) {
            throw new IllegalArgumentException("o ne peut pas �tre null");
        }
        if (estPleine()) {
            throw new PilePleineException();
        }
        zone[ptr] = o;
        ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return zone[ptr - 1];
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Pile) {
            Pile pile = (Pile)o;
            // D�finit si les deux piles ont la m�me capacit� et le m�me nombre d'�l�ments.
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            if (equals) {
                for (int i = ptr - 1; i >= 0; i--) {
                    // Compare chaque �l�ment depuis le sommet de chaque pile.
                    Object a = zone[i], b = pile.zone[i];
                    if (a != null) {
                        equals &= a.equals(b);
                    } else {
                        equals = false;
                    }                   
                    if (!equals) {
                        // Si il existe au moins une diff�rence dans les deux piles c'est qu'elles ne sont pas �gales, il n'est pas n�cessaire de poursuivre la comparaison.
                        break;
                    }
                }
            }
        }
        return equals;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            Object item = zone[i];
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
}