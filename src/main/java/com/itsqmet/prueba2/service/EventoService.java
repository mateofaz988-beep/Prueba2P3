package com.itsqmet.prueba2.service;

import com.itsqmet.prueba2.model.Evento;
import com.itsqmet.prueba2.repository.EventoRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<Evento> listarTodos() { return repository.findAll(); }

    public Evento obtenerPorId(Long id) { return repository.findById(id).orElseThrow(); }

    public Evento crear(Evento evento) { return repository.save(evento); }

    public Evento actualizar(Long id, Evento evento) {
        evento.setId(id);
        return repository.save(evento);
    }

    public void eliminar(Long id) { repository.deleteById(id); }

    public List<Evento> porTipo(String tipo) { return repository.findByTipoOrderByNombreAsc(tipo); }

    public List<Evento> porCapacidadYPonente(Integer capacidad, Long ponenteId) {
        return repository.findByCapacidadGreaterThanEqualAndPonenteId(capacidad, ponenteId);
    }

    public List<Evento> porPonenteFechas(Long ponenteId) {
        return repository.findByPonenteIdOrderByFechaDesc(ponenteId);
    }

    public byte[] generarPdf() throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();
        document.add(new Paragraph("Listado de Eventos"));
        PdfPTable table = new PdfPTable(4);
        table.addCell("Nombre");
        table.addCell("Tipo");
        table.addCell("Fecha");
        table.addCell("Ponente");
        List<Evento> eventos = repository.findAll();
        for (Evento e : eventos) {
            table.addCell(e.getNombre());
            table.addCell(e.getTipo());
            table.addCell(e.getFecha().toString());
            table.addCell(e.getPonente() != null ? e.getPonente().getNombre() : "N/A");
        }
        document.add(table);
        document.close();
        return out.toByteArray();
    }
}