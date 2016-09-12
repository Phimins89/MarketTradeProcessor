/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.websocket.OnClose
 *  javax.websocket.OnMessage
 *  javax.websocket.OnOpen
 *  javax.websocket.RemoteEndpoint
 *  javax.websocket.RemoteEndpoint$Basic
 *  javax.websocket.Session
 *  javax.websocket.server.ServerEndpoint
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package org.sample.tradeprocessor;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONException;
import org.json.JSONObject;

@ServerEndpoint(value="/tradeprocessorendpoint")
public class MessageProcessor {
    private static Set peers = Collections.synchronizedSet(new HashSet());

    @OnMessage
    public void onMessage(String message) throws JSONException {
        JSONObject obj = new JSONObject(message);
        String pageName = obj.getString("originatingCountry");
        if (pageName.equals("EN")) {
            ++org.sample.tradeprocessor.JFreeChartServlet.EN;
        } else if (pageName.equals("US")) {
            ++org.sample.tradeprocessor.JFreeChartServlet.US;
        } else if (pageName.equals("FR")) {
            ++org.sample.tradeprocessor.JFreeChartServlet.FR;
        } else if (pageName.equals("DE")) {
            ++org.sample.tradeprocessor.JFreeChartServlet.DE;
        } else {
            System.out.println("No originating Countries were found in message");
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("mediator: opened websocket channel for client ");
        peers.add(session);
        try {
            session.getBasicRemote().sendText("good to be in touch");
        }
        catch (IOException var2_2) {
            // empty catch block
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("mediator: closed websocket channel for client");
        peers.remove((Object)session);
    }
}
