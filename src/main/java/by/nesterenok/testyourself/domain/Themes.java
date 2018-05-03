package by.nesterenok.testyourself.domain;

public final class Themes extends Entity{

	private static final long serialVersionUID = -699934497619445998L;
	
	private String theme;
	private boolean aprooved;
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public boolean isAprooved() {
		return aprooved;
	}
	public void setAprooved(boolean aprooved) {
		this.aprooved = aprooved;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (aprooved ? 1231 : 1237);
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Themes other = (Themes) obj;
		if (aprooved != other.aprooved)
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Themes [theme=" + theme + ", aprooved=" + aprooved + "]";
	}
	
	
	
	
}
