package ClassPractice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest{

	public static void main(String[] args) {
		
		Person[] persons = {
				new Person("김재환", 27),
				new Person("이동욱", 16),
				new Person("강태오", 27)
				
		};
		
		//Comparable type이 아니라서 에러가 난다. 그렇다고 비교할게 없잖아 그니까 아무것도 못해 얘는 ㅠ
//		//override해야하마
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
		
//		//나이순으로 하고싶어
//		Arrays.sort(persons, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
////				return Integer.compare(o1.getAge(), o2.getAge());
//				return o1.getAge() - o2.getAge();
//			}
//			
//			
//		}); //비교할 애, 비교도우미인 comparator
		//=====람다로 바꿔보기======// 데이터가 모두 양수거나 모두 음수 즉, 부호가 같을때는 문제가없다.
		//하지만 부호가 다르다면 음수에서 양수를 빼면 언더플로우가 발생할수잇음
		//양수-음수 빼면 overflow가 일어날수도 ㅋㅋ 
		//나머지는직접 
		//기본을 오름차순으로 생각하고 구현을 하는거야. 
		//근데 내림차순을 바꾸고싶다?? 비교하는 순서를 뒤집거나 하면 된다 
		Arrays.sort(persons, (o1, o2) -> o1.getAge() - o2.getAge());
		
		System.out.println(Arrays.toString(persons));
		
		//primitive type은 내림차순하려면 wrapper class쓰는거박에없나요?? 네 !
	
		//comparator가 우선이다
		//비교판단 도우미가 있으면 무조건 비교판단 도우미한테 물어보지만, 그렇지 않으면 원소한테 물어본다.
		//하지만 COMPARABLE을 구현하고 있어도 COMPARATOR한테 물어본다는거야
	
		//이름으로 오름차순? 
		Arrays.sort(persons, Comparator.reverseOrder()); //Comparator에 static으로 있는 reverseOrder잇음
		//Comparator의 reverse 주의점 : Comparator구현체를 반환
		//							Comparable한 원소의 기능을 이용하여 그 구현의 반대가 리턴되도록 구현 (일단 원소는Comaprable해야함)
		//							진짜 뒤집어만 주는 중. 뭘 기준으로 뒤집을지 몰라도돼 걍 
	}

}
