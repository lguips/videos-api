package videos_api.videos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import videos_api.videos.domain.video.DadosCadastroVideo;
import videos_api.videos.domain.video.Video;
import videos_api.videos.repositories.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video create(DadosCadastroVideo dados) {
        var video = new Video(dados.titulo(), dados.descricao(), dados.url());
        return videoRepository.save(video);
    }
}