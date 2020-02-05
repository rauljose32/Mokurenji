while :
do
	if [ -e "/home/thanyla.sales/comandos" ];
	then
		while read linha
		do
			id=$(echo $linha|awk '{print $1}')
			echo $id
			case $id in
				
				11) ## Interface Adicionar
					comando=`echo "ifconfig" $(echo $linha|awk '{print $2" "$3"/"$4}')`
					echo $comando
				;;

				12) ## Interface Deletar
		            limpa=`echo "ip address flush dev " $(echo $linha|awk '{print $2"}')` 
                    echo $limpa
                    $limpa
                    reiniciar= /etc/init.d/networking restart 
                    $reiniciar
                    parar= /etc/init.d/networking stop
                    $parar
                    iniciar= /etc/init.d/networking start
                    $iniciar
                    $reiniciar
				;;

				21) ## Rota Default Adicionar
					comando=`echo "route add default gw "$(echo $linha|awk '{print $2}')`
					echo $comando
				;; 

				22) ## Rota Default Deletar
					comando=`echo "route del default gw "$(echo $linha|awk '{print $2}')`
					echo $comando
				;;

				31) ## Rota Host Adicionar
					comando=`echo "route add -host "$(echo $linha|awk '{print $2" gw "$3}')`
					echo $comando
				;;

				32) ## Rota Host Deletar
					comando=`echo "route del -host "$(echo $linha|awk '{print $2" gw "$3}')`
					echo $comando
				;;

				41) ## Rota Rede Adicionar
					comando=`echo "route add -net "$(echo $linha|awk '{print $2"/"$3" gw "$4}')`
					echo $comando
				;;

				42) ## Rota Rede Deletar
					comando=`echo "route del -net "$(echo $linha|awk '{print $2"/"$3" gw "$4}')`
					echo $comando
				;;

				51) ## Nat Entrada Adicionar
					comando=`echo "iptables -t nat -A PREROUTING -d "$(echo $linha|awk '{print $2" -p tcp --dport "$3" -j DNAT --to-destination "$4":"$5}')`
					echo $comando
				;;

				52) ## Nat Entrada Deletar
					comando=`echo "iptables -t nat -D PREROUTING -d "$(echo $linha|awk '{print $2" -p tcp --dport "$3" -j DNAT --to-destination "$4":"$5}')`
					echo $comando
				;;

				61) ## Nat Saida Adicionar
					comando=`echo "iptables -t nat -A POSTROUTING -o "$(echo $linha|awk '{print $2" -j MASQUERADE"}')`
					echo $comando
				;;

				62) ## Nat Saida Deletar
					comando=`echo "iptables -t nat -D POSTROUTING -o "$(echo $linha|awk '{print $2" -j MASQUERADE"}')`
					echo $comando
				;;

				71) 
					comando=`echo "apt-get install openvpn -y"`
			    		echo $comando
					$comando
			    		echo "dev tun
					cd /etc/openvpn
					secret chave
					user nobody
					group nogroup
					comp-lzo
					ping 15
					verb 3" > /etc/openvpn/pontaA.conf
			    		comando=`echo "ifconfig "$(echo $linha|awk '{print $2" "$3}')`
			    		echo $comando
					echo $comando >> /etc/openvpn/pontaA.conf
					#echo $comando >> /home/matheus.coelho/pontaA.conf
			    		comando=`echo "--float"`
			    		echo $comando
			    		echo $comando >> /etc/openvpn/pontA.conf
			    		comando=`echo "remote "$(echo $linha|awk '{print $4}')`
			    		echo $comando
  			    		echo $comando >> /etc/openvpn/pontaA.conf
					#echo $comando >> /home/matheus.coelho/pontaA.conf
			    		comando=`echo "port "$(echo $linha|awk '{print $5}')`
			   		echo $comando
			    		echo $comando >> /etc/openvpn/pontaA.conf
					#echo $comando >> /home/matheus.coelho/pontaA.conf
			    		echo  "## 2048 bit OpenVPN static key#
					-----BEGIN OpenVPN Static key V1-----
					d5b7c64afb86123cb4fadd74c6bf3c71
					610200a9afbf83d5c697e020f29637d0
					6a632b75b88cafd83711530e50f0eca4
					ea3465a8aa7f3ae7379b16a88b7781c4
					8cb80d9706740b8f2cd7b75579db0335
					a8b9516bcbef36b6f6ea12d5e371c449
					553b0f968246c7ad7f27a09a9d057b52
					394850d3a0c3709a0be905131931b34e
					7f3265aa557a7d9fc2cfff8cd65f8127
					f399f6b31cdc60db57af2ae0c95ae950
					3d594af123b7f8bbf05e941e732c2f44
					6da22856458f3adf026a6b82155a1327
					e20375d3700bb5018fa6a401651a5836
					7a719b40ca0bb3c4cd4796f5746ccd3e
					76bf93b0b8dca9d78b90e8dca8cc00be
					1dbcc4e4cdb7b93d0366ccdb1a854b8e
					-----END OpenVPN Static key V1-----" > /etc/openvpn/chave
					comando=`echo "openvpn /etc/openvpn/pontaA.conf"`
					echo $comando
			    	;;

				72) ## VPN Deletar
					comando=`echo "killall -9 openvpn"`
					echo $comando
				;;

				81) ## HostApd Adiconar
					touch /etc/hostapd/hostapd.conf
					interface=`echo $linha|awk '{print $2}'`
					ssid=`echo $linha|awk '{print $3}'`
					channel=`echo $linha|awk '{print $4}'`

					echo interface=$interface > /etc/hostapd/hostapd.conf
					echo driver=nl80211 >> /etc/hostapd/hostapd.conf
					echo ssid=$ssid >> /etc/hostapd/hostapd.conf
					echo hw_mode=g >> /etc/hostapd/hostapd.conf
					echo channel=$channel >> /etc/hostapd/hostapd.conf
					comando= "hostapd -B /etc/hostapd/hostapd.conf"
					echo $comando
				;;

				82) ## HostApd Deletar 
					comandos= "killall -9 hostapd >> log_execucao 2>> log_erro"
				;;

				91) ## Dhcpd Adicionar
					touch /etc/dhcp/dhcpd.conf

					rm /var/lib/dhcp/dhcpd.leases
					touch /var/lib/dhcp/dhcpd.leases

					enderecoSubrede= `echo $linha|awk '{print $5}'`
					mascaraSubrede= `echo $linha|awk '{print $6}'`
					rangeInicio= `echo $linha|awk '{print $7}'`
					rangeFinal= `echo $linha|awk '{print $8}'`
					gateway= `echo $linha|awk '{print $9}'`
					broadcast= `echo $linha|awk '{print $10}'`
				
					echo ddns-update-style none; > /etc/dhcp/dhcpd.conf
					echo default-lease-time 7200; >> /etc/dhcp/dhcpd.conf
					echo max-lease-time 14400; >> /etc/dhcp/dhcpd.conf
					echo authoritative; >> /etc/dhcp/dhcpd.conf

					echo subnet $enderecoSubrede netmask $mascaraSubrede { >> /etc/dhcp/dhcpd.conf
					echo range $rangeInicio $rangeFinal; >> /etc/dhcp/dhcpd.conf
					echo option routers $gateway; >> /etc/dhcp/dhcpd.conf
					echo option netbios-name-servers 8.8.8.8; >> /etc/dhcp/dhcpd.conf
					echo option domain-name-servers  8.8.8.8, 4.2.2.2; >> /etc/dhcp/dhcpd.conf
					echo option broadcast-address $broadcast; >> /etc/dhcp/dhcpd.conf
					echo } >> /etc/dhcp/dhcpd.conf
					comando= "dhcpd -cf /etc/dhcp/dhcpd.conf"
					echo $comando
				;;

				92)
					comando= "killall -9 dhcpd >> log_execucao 2>> log_erro"
				;;
			esac
			
		##$comando >> log_execucao 2>> log_erro
		done < /home/thanyla.sales/comandos
		##rm /home/thanyla.sales/comandos
	fi
done
