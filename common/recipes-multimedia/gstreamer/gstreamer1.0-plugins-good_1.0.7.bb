include gstreamer1.0-plugins-good.inc

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-good/gst-plugins-good-1.0.7.tar.xz"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=622921ffad8cb18ab906c56052788a3f \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe"

SRC_URI[md5sum] = "e4b1c825475a9b478fe29e8e9f34516f"
SRC_URI[sha256sum] = "a016a3b377c86658627aef902b9204108209100b2e88fcc3b695c392af1b4035"

S = "${WORKDIR}/gst-plugins-good-${PV}"

PRINC := "${@int(PRINC) + 1}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('cairo', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('flac', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('gdk-pixbuf', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('jpeg', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('libpng', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('soup', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('speex', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('taglib', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('pulseaudio', '')}"
PACKAGECONFIG := "${@'${PACKAGECONFIG}'.replace('x11', '')}"

EXTRA_OECONF += "--disable-nls"
