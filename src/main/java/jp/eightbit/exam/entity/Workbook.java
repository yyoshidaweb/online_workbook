package jp.eightbit.exam.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Workbook {
	private Long id;
	
	@NotBlank(message = "問題集のタイトルを入力してください。")
	private String title;
	
	@NotNull(message = "問題集の価格を入力してください。")
	@Min(value = 0, message = "0以上の数値を入力してください。")
	@Max(value = 1000000, message = "1000000以下の数値を入力してください")
	private Integer price;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Workbook [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
}
