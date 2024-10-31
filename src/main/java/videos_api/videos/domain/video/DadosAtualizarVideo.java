package videos_api.videos.domain.video;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarVideo(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String url
) {
}