package videos_api.videos.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import videos_api.videos.domain.video.DadosAtualizarVideo;
import videos_api.videos.domain.video.DadosCadastroVideo;
import videos_api.videos.domain.video.DadosDetalhamentoVideo;
import videos_api.videos.services.VideoService;

@RequestMapping("/videos")
@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @Transactional
    @PostMapping
    public ResponseEntity<DadosDetalhamentoVideo> register(@RequestBody @Valid DadosCadastroVideo dados, UriComponentsBuilder uriBuilder) {
        var video = videoService.create(dados);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVideo(video));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoVideo>> findAll(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {
        Page<DadosDetalhamentoVideo> page = videoService.findAllPageable(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosDetalhamentoVideo> findById(@PathVariable Long id) {
        var video = videoService.findById(id);
        return ResponseEntity.ok().body(new DadosDetalhamentoVideo(video));
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        videoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosDetalhamentoVideo> updateById(@RequestBody @Valid DadosAtualizarVideo dados) {
        var video = videoService.updateById(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoVideo(video));
    }
}
