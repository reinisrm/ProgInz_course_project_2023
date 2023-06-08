package lv.venta.models.users;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idc;
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 15)
	public String Title;
	
	@Min(value = 1)
	@Max(value = 20)
	@Column(name = "CreditPoints")
	private int creditPoints;
	

	
	

	public Course(@NotNull @Size(min = 3, max = 15) String title, @Min(1) @Max(20) int creditPoints) {
		Title = title;
		this.creditPoints = creditPoints;
		
	}
	
	
	

}
