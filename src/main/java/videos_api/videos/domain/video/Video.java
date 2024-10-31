package videos_api.videos.domain.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public Video(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public void updateVideo(DadosAtualizarVideo dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }

        if (dados.url() != null) {
            this.url = dados.url();
        }
    }
}
