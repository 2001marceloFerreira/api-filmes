package br.com.apifilmesseriesfree.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Filme")
@EntityListeners(AuditingEntityListener.class)
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

//    @Lob
    @Column(name = "imagem_base64", columnDefinition = "TEXT")
    private String imagemBase64;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

}
