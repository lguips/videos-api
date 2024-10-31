package videos_api.videos.domain.video;

public record DadosDetalhamentoVideo(Long id, String titulo, String descricao, String url) {
    public DadosDetalhamentoVideo(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
