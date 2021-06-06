package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


import co.memo.model.Memo;

public class MemoList implements MemoAccess {

	ArrayList<Memo> memos;

	// open
	String path = "c:/dev/memo.txt";

	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				if (!scanner.hasNext())
					break;
				String str = scanner.nextLine();
				String[] arr = str.split(",");
				memos.add(new Memo(arr[0], arr[1]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 저장
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Memo f : memos) {
				fw.write(String.format("%s,%s\n", f.getDate(), f.getContent()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemoList() {
		memos = new ArrayList<Memo>();
		open();
	}

	// 등록
	@Override
	public void insert(Memo memo) {
		memos.add(memo);
		save();

	}

	// 수정
	@Override
	public void update(Memo memo) {
		for (Memo f : memos) {
			if (f.getDate().equals(memo.getDate())) {
				f.setContent(memo.getContent());
				save();
			}
		}
	}

	// 검색해서 삭제
	@Override
	public void delete(String date) {
		for (Memo f : memos) {
			if (f.getDate().equals(date)) {
				memos.remove(f);
				save();
				break;
			}
		}

	}

	// 전체조회
	@Override
	public ArrayList<Memo> listAll() {
		return memos;
	}

	// 검색
	@Override
	public Memo findDate(String date) {
		for (Memo f : memos) {
			if (f.getDate().equals(date)) {
				return f;
			}
		}
		return null;
	}

	// 내용 검색
	@Override
	public Memo findContent(String content) {
		for (Memo f : memos) {
			if (f.getContent().contains(content)) {
				return f;
			}
		}
		return null;
	}

}
