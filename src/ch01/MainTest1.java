package ch01;

public class MainTest1 {

	public static void main(String[] args) {

		ThreeDPinter dPinter1 = new ThreeDPinter();
		dPinter1.setMaterial(new Plastic());
		System.out.println(dPinter1.material.toString());

		// 위 ThreeDPrinter 한계는 재호가 플라스틱에 종속되어 있다.
		// 하지만 사용자 입장에서 재료를 파우더로 변경한다면
		// 코드의 수정이나 새로운 클래스가 필요하다.
		
		System.out.println("-----------------------");
		
		ThreeDPinter2 dPinter2 = new ThreeDPinter2();
		dPinter2.setMaterial(new Powder());
		System.out.println(dPinter2.material.toString());
		
		System.out.println("-----------------------");
		
		ThreeDPinter3 dPinter3 = new ThreeDPinter3();
		dPinter3.setMaterial(new Plastic()); // 컴파일 시점에 오류 없음
		System.out.println(dPinter3.material.toString());
		
		System.out.println("-----------------------");
		
		ThreeDPinter3 dPinter3_2 = new ThreeDPinter3();
		dPinter3_2.setMaterial(new Powder());
		System.out.println(dPinter3_2.material.toString());

		Plastic plastic01 = (Plastic) dPinter3.getMaterial(); // 다운 캐스팅
		// 컴파일 시점에 오류 발생 - 타입 불일치(getMaterial() 는 Object 타입임)
		// Powder powder01 = (Powder) dPinter1.getMaterial(); // 형 변환 오류 발생 코드가 된다.

	}

}
