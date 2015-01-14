package test.config.entity;

public enum Color {
	Red("1"),Black("2");
	private String name;
	private Color(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
}
