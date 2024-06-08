package com.boombastic.mediateca.utils.services.impl;
import com.boombastic.mediateca.utils.dtos.LibroDto;
import com.boombastic.mediateca.utils.models.Libro;
import com.boombastic.mediateca.utils.repository.LibroRepository;
import com.boombastic.mediateca.utils.services.LibroService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {


    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        return  libros.stream().map(this::mapToLibroDto).collect(Collectors.toList());

    }


    @Override
    public Libro findLibroById(Long libroId) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return mapToLibroDto(libro);
    }

    @Override
    public void saveLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void updateLibro(LibroDto libroDto) {
        Libro libro = mapToLibro(libroDto);
        libroRepository.save(libro);
    }

    @Override
    public void delete(Long libroId) {
        libroRepository.deleteById(libroId);
    }

    private Libro mapToLibroDto(Libro libro) {
        return LibroDto.builder()
                .id(libro.getIdLibro())
                .idDocumento(libro.getIdDocumento().getIdDocumento())
                .titulo(libro.getTitulo())
                .autor(libro.getAutor())
                .genero(libro.getGenero())
                .isbn(libro.getIsbn())
                .editorial(libro.getEditorial())
                .numPaginas(libro.getNumPaginas())
                .build();



    }
    private Libro mapToLibro(LibroDto libroDto) {
        return Libro.builder()
                .idLibro(libroDto.getId())
                .titulo(libroDto.getTitulo())
                .autor(libroDto.getAutor())
                .genero(libroDto.getGenero())
                .isbn(libroDto.getIsbn())
                .editorial(libroDto.getEditorial())
                .numPaginas(libroDto.getNumPaginas())
                .build();
    }

}
