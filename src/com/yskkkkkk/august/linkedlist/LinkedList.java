package com.yskkkkkk.august.linkedlist;

class LinkedList {

	private ListNode head; // ListNode 타입의 head 노드 인스턴스 변수

	public LinkedList() {
		head = null; // head 노드 초기화
	}

	public void insertFirst(int data) {
		ListNode newNode = new ListNode(data); // 새로운 노드 생성
		if (head == null) {
			this.head = newNode;
		} else {
			ListNode tempNode = head;

			while (tempNode.link != null) {
				tempNode = tempNode.link; // 다음 노드를 참조
			}

			tempNode.link = newNode;
		}
	}

	public ListNode search(int index) {

		ListNode x = head; // head가 기리키는 노드부터 시작

		for (int i = 0; i < index; i++) {
			x = x.link; // x노드의 다음 노드를 x에 저장한다
		}
		return x;
	}

	public void add(int index, int data) {

		if (index == -1) {
			ListNode newNode = new ListNode(data);	// 새 노드 생성
			newNode.link = head;	// 새 노드의 다음 노드로 head 노드를 연결
			head = newNode;	// head가 가리키는 노드를 새 노드로 변경
			return;
		}
		
		// 추가하려는 위치의 이전 노드
		ListNode prev_Node = search(index);
		
		// 추가하려는 위치의 노드
		ListNode next_Node = prev_Node.link;

		// 추가하려는 노드
		ListNode newNode = new ListNode(data);

		prev_Node.link = null;
		prev_Node.link = newNode;
		newNode.link = next_Node;
	}

	public void printList(int count) {
		ListNode tempNode = this.head; // tempNode에 head가 가리키는 첫번째 노드를 할당

		// tempNode가 null이 아닐 때까지 반복하여 출력
		for (int i = 0; i < count; i++) {
			System.out.print(tempNode.getData() + " ");
			tempNode = tempNode.link; // temp 노드에 다음 노드(tempNode.link) 할당.
		}
		System.out.println();
	}

}
