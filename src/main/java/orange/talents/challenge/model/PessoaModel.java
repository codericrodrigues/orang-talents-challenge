package orange.talents.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
public class PessoaModel {

    @Id
    @Column(name = "cpf")
    @NotNull(message = "O CPF não pode ser vazio")
    @CPF(message = "CPF Inválido")
    private String cpf;

    @Column(name = "email", length = 128, unique = true)
    @NotNull(message = "O E-mail não pode ser vazio")
    @Email(message = "E-mail Inválido")
    private String email;

    @Column(name = "nome")
    @NotNull(message = "O Nome não pode ser vazio")
    @Size(min=2, message= "Nome precisa ter no mínimo 2 caracteres")
    private String nome;

    @Column(name = "dt_nascimento")
    @NotNull(message = "A data de nascimento não pode ser vazia")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
