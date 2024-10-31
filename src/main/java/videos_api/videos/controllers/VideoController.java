package videos_api.videos.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import videos_api.videos.domain.video.DadosCadastroVideo;
import videos_api.videos.domain.video.DadosDetalhamentoVideo;
import videos_api.videos.services.VideoService;

@RequestMapping("/videos")
@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoVideo> register(@RequestBody @Valid DadosCadastroVideo dados, UriComponentsBuilder uriBuilder) {
        var video = videoService.create(dados);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVideo(video));
    }
}
