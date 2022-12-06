package kr.bit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity //DataBase의 Table
@Data
public class Board { // VO <----- ORM -----> Table
	
	//table의 역할을 함.
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
	private Long idx; //자동증가대상
	private String title;
	private String content;
	
	@Column(updatable = false)
	private String writer;
	
	@Column(insertable = false, updatable = false, columnDefinition = "datetime default now()") //컬럼을 상세히 설정
	private Date indate; //now()
	@Column(insertable = false, updatable = false, columnDefinition = "int default 0")
	private Long count;
	
}
