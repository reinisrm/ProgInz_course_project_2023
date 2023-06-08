package lv.venta.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "user_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idu;
	
	@Column(name = "Password")
	@NotNull
	//TODO papildinat ar validaciju, kad ir zinams passwordEncoder
	private String password; //TODO kad pievienos spring security, tad jauzliek passwordEncoder
	
	@Column(name = "Email")
	@NotNull
	@Email
	private String email;

	public User(@NotNull String password, @NotNull @Email String email) {
		this.password = password;
		this.email = email;
	}
	
	@OneToOne(mappedBy = "user")
	private Person person;
	
	
	
	

}
