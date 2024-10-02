package jp.eightbit.exam.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Chapter {
	private Long id;
	
	@NotNull(message = "章番号を入力してください。")
	@Min(value = 0, message = "0以上の数値を入力してください。")
	@Max(value = 1000000, message = "1000000以下の数値を入力してください")
	private Integer number;
	
	@NotBlank(message = "章の名前を入力してください。")
	private String name;
	
	private Long workbookId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getWorkbookId() {
		return workbookId;
	}

	public void setWorkbookId(Long workbookId) {
		this.workbookId = workbookId;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", number=" + number + ", name=" + name + ", workbookId=" + workbookId + "]";
	}

	
}
