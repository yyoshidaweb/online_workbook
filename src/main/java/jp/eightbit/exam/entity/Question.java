package jp.eightbit.exam.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Question {
	private Long id;
	
	@NotNull(message = "問題番号を入力してください。")
	@Min(value = 0, message = "0以上の数値を入力してください。")
	@Max(value = 1000000, message = "1000000以下の数値を入力してください")
	private Integer number;
	
	@NotBlank(message = "問題文を入力してください。")
	private String sentence;
	
	private Long chapterId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", number=" + number + ", sentence=" + sentence + ", chapterId=" + chapterId
				+ "]";
	}
}