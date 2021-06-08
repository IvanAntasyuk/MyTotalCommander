package handlers;

import common_msg.RegistrationMessage;
import database_connect.DBConnection;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class RegistrationHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws Exception {

            if (message instanceof RegistrationMessage) {
                RegistrationMessage registration = (RegistrationMessage) message;
                String nick = DBConnection.getIdByLoginAndPass(registration.login, registration.password);
                if (nick != null) {
                    RegistrationMessage r = new RegistrationMessage("/not_null_userId");
                    ctx.writeAndFlush(r);
                } else {
                    DBConnection.registrationByLoginPassAndNick(registration.login, registration.password, registration.nick);
                    Files.createDirectory(Paths.get("server_" + registration.nick));
                    RegistrationMessage r = new RegistrationMessage("/registration_Ok " + registration.nick);
                    ctx.writeAndFlush(r);
                }
                return;
            }


            ctx.fireChannelRead(message);

    }
}
