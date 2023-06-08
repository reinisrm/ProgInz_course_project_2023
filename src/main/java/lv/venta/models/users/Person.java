package lv.venta.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Person {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idp;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 15)
	public String name;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Surname")
	public String surname;
	
	@NotNull
	//TODO apdomat un pielietot risinajumu arzemju studentiem un jaunajiem LV personas kodiem
	@Size(min = 12, max = 12)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}", message= "Neatbilstošs personas kods")
	@Column(name = "PersonCode")
	private String personcode;
	
	@OneToOne
	@JoinColumn(name = "idu")
	private User user;

	public Person(@NotNull @Size(min = 3, max = 15) String name, @NotNull @Size(min = 3, max = 15) String surname,
			@NotNull @Size(min = 12, max = 12) @Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Neatbilstošs personas kods") String personcode,
			User user) {
		super();
		this.name = name;
		this.surname = surname;
		this.personcode = personcode;
		this.user = user;
	}
	
	
	
	
	
}
