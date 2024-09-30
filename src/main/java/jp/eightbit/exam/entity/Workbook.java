package jp.eightbit.exam.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Workbook {
	private Long id;
	
	@NotBlank(message = "問題集のタイトルを入力してください。")
	private String title;
	
	@Min(value = 0, message = "0以上の数値を入力してください。")
	@Max(value = 1000000, message = "1000000以下の数値を入力してください。")
	private float price;
}
