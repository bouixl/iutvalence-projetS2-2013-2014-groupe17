
public class Position {
	private int ligne;
	private int colonne;
	
	public Position(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public int obtenirColonne() {
		return this.colonne;
	}
	
	public int obtenirLigne() {
		return this.ligne;
	}
	
	public boolean estValideDansCarte(Carte carte) {
		return ((this.ligne>=0 && this.ligne<carte.obtenirHauteur()) && (this.colonne>=0 && this.colonne<carte.obtenirLargeur()));
	}
	
	public Position ajouterOffset(Direction direction)
	{
		return new Position(this.ligne + direction.obtenirOffsetLigne(), this.colonne + direction.obtenirOffsetColonne());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colonne;
		result = prime * result + ligne;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if ((this.ligne == other.obtenirLigne()) && (this.colonne == other.obtenirColonne()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Position [ligne=" + ligne + ", colonne=" + colonne + "]";
	}
}
