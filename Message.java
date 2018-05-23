package com.rps.facades;


import java.awt.image.BufferedImage;

@FunctionalInterface
public interface Message {
   String transferMessage(	BufferedImage file);
   
}
