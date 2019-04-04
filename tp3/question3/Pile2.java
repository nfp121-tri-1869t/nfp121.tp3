package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    private Stack<T> stk;
    private int capacite;

    /** Cr�ation d'une pile.
     * @param taille la "taille maximale" de la pile, doit �tre > 0
     */
    public Pile2(int taille){
        if (taille < 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.capacite = taille;
    }

        public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Retourne la taille actuelle de la pile.
    */
    public int taille() {
        return stk.size();
    }
    
    /**
     * Retourne la capacit� maximale de la pile.
    */
    public int capacite() {
        return capacite;
    }

    /**
     * Ajoute un objet en haut de la pile.
    */
    public void empiler(T o) throws PilePleineException{
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (estPleine()) {
            throw new PilePleineException();
        }

        stk.push(o);
    }

    /**
     * Retire et retourne l'objet au sommet de la pile.
    */
    public T depiler() throws PileVideException{
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    /**
     * Retourne l'objet au sommet de la pile sans le retirer.
    */
    public T sommet() throws PileVideException{
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }
    
    /**
     * D�finit si la pile est pleine.
     * 
     * @return Un bool�en indiquant si la pile est pleine.
     */
    public boolean estPleine() {
        return stk.size() == capacite;
    }
    
    /**
     * D�finit si la pile est vide (ne contient aucun �l�ment).
     * 
     * @return Un bool�en indiquant si la pile est vide.
     */
    public boolean estVide() {
        return stk.isEmpty();
    }
        
    /**
     * Compare l'�galit� de deux piles.
     * 
     * @return Un bool�en indiquant l'�galit� ou non de des deux piles.
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Pile2) {
            Pile2<T> pile = (Pile2<T>)o;
            // D�finit si les deux piles ont la m�me capacit� et le m�me nombre d'�l�ments.
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            for (int i = stk.size() - 1; i >= 0; i--) {
                // Compare chaque �l�ment depuis le sommet de chaque pile.
                T a = stk.elementAt(i), b = pile.stk.elementAt(i);
                if (a != null) {
                    equals &= a.equals(b);
                } else {
                    equals = false;
                }                   
                if (!equals) {
                    // Si il existe au moins une diff�rence dans les deux 
                    // piles c'est qu'elles ne sont pas �gales, 
                    // il n'est pas n�cessaire de poursuivre la comparaison.
                    break;
                }
            }
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
    /**
     * Convertit la pile en chaine de caract�res.
     * 
     * @return Une chaine de caract�res au format "[{0}, {1}, {n}]" ou <b>{n}</b> 
     * repr�sente l'objet � l'index <b>n</b> convertit lui aussi en chaine de caract�re.
     */
    @Override
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
}