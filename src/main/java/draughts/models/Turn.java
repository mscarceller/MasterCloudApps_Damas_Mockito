package draughts.models;

public class Turn {

    private Color color;

    Turn(){
        this.color = Color.WHITE;
    }

    void change(){
        this.color = Color.values()[(this.color.ordinal()+1)%2];
    }

	public boolean isColor(Color color) {
		return this.color == color;
    }

    public Color getTurnColor(){
        return this.color;
    }
    
    @Override
    public String toString(){
        return this.color.name();
    }

}