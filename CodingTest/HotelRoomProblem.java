package codingTest;

import java.util.*;

public class Solution {
	static HashMap<Integer, Integer> hashMap;
	// 방에 대해 기록할 hashMap
	// 현재 방번호와 다음방번호 hashMap에 저장할 것.

	public static int[] solution(int K, int[] room_number) {
		int peopleNum = room_number.length; // 고객 수
		int[] answer = new int[peopleNum];

		hashMap = new HashMap<>();

		for (int i = 0; i < peopleNum; i++) {
			answer[i] = findRoom(room_number[i]); 
			// 함수 결과-정답 방 번호 저장 
		}

		return answer;
	}

	public static int findRoom(int roomNumber) {
		if (!hashMap.containsKey(roomNumber)) { // 빈 방일 경우
			hashMap.put(roomNumber, roomNumber + 1);
			// 현재 방번호와 다음방번호(=현재 방번호 + 1) hashMap에 저장
			return roomNumber;
		}

		// 빈 방이 아니면 빈 방 찾을 때까지 재귀적으로 동작.
		// 다음 방번호(증가시켜서 빈 방 나올 때까지 반복됨.) value 값으로 방 배정. 
		int emptyRoom = findRoom(hashMap.get(roomNumber));
		hashMap.put(roomNumber, emptyRoom);
		// 현재 방 번호- 다음 방 번호(다음 빈 방 번호)로 다시 저장.
		return emptyRoom;

	}

	// test용으로 작성한 main 함수
	// main 함수 때문에 위 변수와 함수들도 static 으로 작성했습니다..!
	public static void main(String[] args) {
		// input example 1
		int K = 10;
		int[] room_number = { 1, 3, 4, 1, 3, 1 };

		System.out.println(Arrays.toString(solution(K, room_number)));

		//example 2
		int K2 = 5;
		int[] room_number2 = { 1, 3, 3};
		
		System.out.println(Arrays.toString(solution(K2, room_number2)));
	
		//example 3
		int K3 = 9;
		int[] room_number3 = { 1, 1, 4, 4, 7, 7 };
		
		System.out.println(Arrays.toString(solution(K3, room_number3)));
	
		//example 4
		int K4 = 10;
		int[] room_number4 = { 1, 1, 2, 5, 1, 3, 1 };
		
		System.out.println(Arrays.toString(solution(K4, room_number4)));
	}

}
