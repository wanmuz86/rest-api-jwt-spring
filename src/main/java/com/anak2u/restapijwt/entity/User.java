package com.anak2u.restapijwt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=3, max=50)
	@Column(name="name")
	private String name;
	
	@NotBlank
	@Size(min=3, max=50)
	@Column(name="username")
	private String username;
	
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
	
	@NotBlank
	@Size(min=3, max=50)
	@Column(name="password")
	private String password;

	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();
	
	
	public User(@NotBlank @Size(min = 3, max = 50) String name,
			@NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(min = 3, max = 50) String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	
	
}
