SUMMARY = "GStreamer VSP filter plugin"
SECTION = "multimedia"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

COMPATIBLE_MACHINE = "(salvator-x|ulcb|ebisu)"

RENESAS_VSPFILTER_URL ?= "gitsm://github.com/renesas-rcar/gst-plugin-vspfilter.git;branch=RCAR-GEN3e/1.0.2"

SRC_URI = " \
    ${RENESAS_VSPFILTER_URL} \
"

SRCREV = "c5af044ff9c2e827f2c9a838fe56b753b1a09f39"

S = "${WORKDIR}/git"


inherit autotools pkgconfig

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base pkgconfig"

EXTRA_AUTORECONF_append = " -I ${STAGING_DATADIR}/aclocal"

FILES_${PN} = " \
    ${libdir}/gstreamer-1.0/libgstvspfilter.so \
"

FILES_${PN}-dev = "${libdir}/gstreamer-1.0/libgstvspfilter.la"

FILES_${PN}-staticdev = "${libdir}/gstreamer-1.0/libgstvspfilter.a"

FILES_${PN}-dbg = " \
    ${libdir}/gstreamer-1.0/.debug \
    ${prefix}/src \
"

RDEPENDS_${PN} = "kernel-module-vsp2driver gstreamer1.0-plugin-vspfilter-config"
