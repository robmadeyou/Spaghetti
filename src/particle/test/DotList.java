package particle.test;

public class DotList {
	public static class dots extends Dot{
		public dots(int x, int y) {
			super(x, y);
		}
	}
	static int maxDots = 130000;
	static Dot[] dotList = new Dot[maxDots];
	
	public static void addDot(dots d){
		for(int i = 0; i < maxDots; i++){
			if(dotList[i] == null){
				dotList[i] = d;
				break;
			}
		}
	}
	public static void onUpdate(int delta){
		for(int i = 0; i < maxDots; i++){
			if(dotList[i] != null){
				dotList[i].onUpdate(delta);
			}
		}
	}
}
