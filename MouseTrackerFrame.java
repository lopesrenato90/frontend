// JList que permite seleções multiplas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame
{
   private final JPanel mousePanel; // painel em que o evento do mouse ocorre
   private final JLabel statusBar; // mostra informação do evento

   // MouseTrackerFrame construtor que configura GUI e 
   // registra o evento do mouse
   public MouseTrackerFrame()
   {
      super("Demonstrating Mouse Events");

      mousePanel = new JPanel(); 
      mousePanel.setBackground(Color.WHITE); 
      add(mousePanel, BorderLayout.CENTER); // adiciona painel para JFrame

      statusBar = new JLabel("Mouse outside JPanel"); 
      add(statusBar, BorderLayout.SOUTH); // adiciona rotulo para JFrame

      // cria e registra eventos do mouse
      MouseHandler handler = new MouseHandler(); 
      mousePanel.addMouseListener(handler); 
      mousePanel.addMouseMotionListener(handler); 
   } 

   private class MouseHandler implements MouseListener, 
      MouseMotionListener 
   {
      // MouseListener eventos e manipuladores
      // manipula evento quando o mouse solta imediamente após o click
      @Override
      public void mouseClicked(MouseEvent event)
      {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 

      // manipula o evento quando clica o mouse
      @Override
      public void mousePressed(MouseEvent event)
      {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      // manipula o evento quando solta o mouse
      @Override
      public void mouseReleased(MouseEvent event)
      {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      }

      // manipula o evento quando o mouse entra na área
      @Override
      public void mouseEntered(MouseEvent event)
      {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
         mousePanel.setBackground(Color.GREEN);
      }

      // manipula o evento quando mouse sai da área
      @Override
      public void mouseExited(MouseEvent event)
      {
         statusBar.setText("Mouse outside JPanel");
         mousePanel.setBackground(Color.WHITE);
      }

      // MouseMotionListener manipuladores de eventos
      // manipula o evento quando o usuario clica e arrasta o mouse
      @Override
      public void mouseDragged(MouseEvent event)
      {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 

      // manipula o evento quando usuario movimenta o mouse
      @Override
      public void mouseMoved(MouseEvent event)
      {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));
      } 
   } // fim da classe interna MouseHandler
} // fim da classe MouseTrackerFrame
