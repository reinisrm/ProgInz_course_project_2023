package lv.venta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.models.users.AcademicPersonel;
import lv.venta.models.users.Student;

//parlikt uz citu tabulu, kurai ir saite ar pasniedzeju, kas to temu piedava
//joma
//grutibas pakape
//temas apraksts
//temas pieejamiba

@Table(name = "thesis_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Thesis {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idt;
	
	//TODO PIEVIENOT VALIDACIJAS
	@Column(name = "TitleEn")
	@NotNull
	private String titleEn;
	
	@Column(name = "TitleLv")
	@NotNull
	private String titleLv;
	
	@Column(name = "Aim")
	@NotNull
	private String aim;
	
	@Column(name = "Tasks")
	@NotNull
	private String tasks;
	
	//TODO servisa vai konstruktoraa pie jauna objekta izveides jaizmanto LocalDateTime.now()
	@Column(name = "SubmitDateTime")
	private LocalDateTime submitDateTime;
	
	@Column(name = "StatusFromSupervisor")
	public boolean statusFromSupervisor;
	
	//TODO servisa vai konstruktora uzlikt submit pec noklusejuma
	@Column(name = "AccStatus")
	private AcceptanceStatus accStatus;
	
	@Column(name = "AccDateTime")
	private LocalDateTime accDateTime;
	
	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Ida")
	private AcademicPersonel supervisor;
	//TODO ja nepieciesams, izveidot saiti ar konsultantu/vertetaju utt.
	
	@ManyToMany
	@JoinTable(name = "thesis_reviewers",
	joinColumns = @JoinColumn(name = "Idt"),
	inverseJoinColumns = @JoinColumn(name = "Ida"))
	private Collection<AcademicPersonel> reviewers = new ArrayList<>();
	
	//TODO lidzigu funkciju uztaisit Academicpersonel klasee
	public void addReviewer(AcademicPersonel reviewer) {
		if(!!reviewers.contains(reviewer)) {
			reviewers.add(reviewer);
		}
	}
	
	
}
