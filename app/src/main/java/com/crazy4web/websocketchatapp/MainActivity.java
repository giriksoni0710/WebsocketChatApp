package com.crazy4web.websocketchatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {


    public WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creareWebsocketClient();
    }

    private void creareWebsocketClient() {

        URI uri;

        try {

            // here we connect to the localhost
            uri = new URI("ws://10.0.2.2:8080/websocket");

        }
        catch (URISyntaxException error){

            Log.d("error", ""+error);
            return;

        }


        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {

                Log.d("debug", "websocket session started");

                webSocketClient.send("Hello.");
            }

            @Override
            public void onTextReceived(String message) {

            }

            @Override
            public void onBinaryReceived(byte[] data) {

            }

            @Override
            public void onPingReceived(byte[] data) {

            }

            @Override
            public void onPongReceived(byte[] data) {

            }

            @Override
            public void onException(Exception e) {

            }

            @Override
            public void onCloseReceived() {

            }
        };
    }

}
