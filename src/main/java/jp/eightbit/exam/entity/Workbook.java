package jp.eightbit.exam.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Workbook {
	private Long id;
	
	@NotBlank(message = "問題集のタイトルを入力してください。")
	private String title;
	
	@Digits(integer = 7, fraction = 0, message = "整数を入力してください。")
	@Min(value = 0, message = "0以上の数値を入力してください。")
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Workbook [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
}
