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
public class ReporteService {
    @Autowired
    private EventoRepository eventoRepository;

    public byte[] generarPdfEventos() throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("Listado de Eventos y Ponentes"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(4);
        table.addCell("Evento");
        table.addCell("Tipo");
        table.addCell("Fecha");
        table.addCell("Ponente");

        List<Evento> eventos = eventoRepository.findAll();
        for (Evento e : eventos) {
            table.addCell(e.getNombre());
            table.addCell(e.getTipo());
            table.addCell(e.getFecha().toString());

            table.addCell(e.getPonente() != null ? e.getPonente().getNombre() : "Sin asignar");
        }

        document.add(table);
        document.close();
        return out.toByteArray();
    }
}