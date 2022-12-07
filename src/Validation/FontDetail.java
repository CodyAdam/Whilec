package Validation;

public class FontDetail {

    private Color color;
    private boolean bold;
    private boolean underline;

    /**
     * Create Font Detail, a font can't be bold and underlined at the same time (bold effect will be ignored)
     * @param color
     * @param bold
     * @param underline
     */
    public FontDetail(Color color, boolean bold, boolean underline) {
        this.color = color;
        this.bold = bold;
        this.underline = underline;
        if(this.bold && this.underline) this.bold = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isUnderline() {
        return underline;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FontDetail other = (FontDetail) obj;
        return (this.color == other.color && this.bold == other.bold && this.underline == other.underline);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.color != null ? this.color.hashCode() : 0);
        hash = 97 * hash + (this.bold ? 1 : 0);
        hash = 97 * hash + (this.underline ? 1 : 0);
        return hash;
    }

}
